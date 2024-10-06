#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys
import math
from hdfs import InsecureClient


def get_probs(hdfs_filepath):
    client = InsecureClient("http://namenode:50070")
    priors, conditional_probs = {}, {}

    with client.read(hdfs_filepath) as reader:
        for line in reader:
            key, count = line.decode().strip().split("\t")
            title, value = key.split(":")
            if title == "label":
                priors[value] = int(count)
            else:
                conditional_probs[key] = int(count)

    total = sum(priors.values())
    for key in priors.keys():
        priors[key] /= total

    for key in conditional_probs.keys():
        _, label = key.split("|")
        conditional_probs[key] /= priors[label]

    return priors, conditional_probs


def mapper():
    priors, conditional_probs = get_probs("train_output")

    for line in sys.stdin:
        line = line.strip()
        outlook, temperature, humidity, wind = line.split()

        # Calculate log-likelihood
        scores = {"yes": math.log(priors["yes"]), "no": math.log(priors["no"])}

        scores["yes"] += math.log(conditional_probs.get(f"outlook:{outlook}|yes", 1e-6))
        scores["yes"] += math.log(
            conditional_probs.get(f"temperature:{temperature}|yes", 1e-6)
        )
        scores["yes"] += math.log(
            conditional_probs.get(f"humidity:{humidity}|yes", 1e-6)
        )
        scores["yes"] += math.log(conditional_probs.get(f"wind:{wind}|yes", 1e-6))

        scores["no"] += math.log(conditional_probs.get(f"outlook:{outlook}|no", 1e-6))
        scores["no"] += math.log(
            conditional_probs.get(f"temperature:{temperature}|no", 1e-6)
        )
        scores["no"] += math.log(conditional_probs.get(f"humidity:{humidity}|no", 1e-6))
        scores["no"] += math.log(conditional_probs.get(f"wind:{wind}|no", 1e-6))

        for label, score in scores.items():
            print(f"{label}\t{score}")


if __name__ == "__main__":
    mapper()
