#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys
import math
"""
from hdfs import InsecureClient # type: ignore

def get_probs(filepath):
    client = InsecureClient('http://0.0.0.0:9870')
    priors, conditional_probs = {}, {}

    with client.read(filepath) as reader:
        for line in reader:
            key, count = line.decode().strip().split("\t")
            title, value = key.split(":")
            if title == "label":
                priors[value] = int(count)
            else:
                conditional_probs[key] = int(count)

    for key in conditional_probs.keys():
        _, label = key.split("|")
        conditional_probs[key] /= priors[label]

    total = sum(priors.values())
    for key in priors.keys():
        priors[key] /= total

    return priors, conditional_probs
"""

def get_probs(filepath):
    priors, conditional_probs = {}, {}

    with open(filepath, 'r') as reader:
        for line in reader.readlines():
            key, count = line.strip().split("\t")
            title, value = key.split(":")
            if title == "label":
                priors[value] = int(count)
            else:
                conditional_probs[key] = int(count)

    for key in conditional_probs.keys():
        _, label = key.split("|")
        conditional_probs[key] /= priors[label]

    total = sum(priors.values())
    for key in priors.keys():
        priors[key] /= total

    return priors, conditional_probs


def mapper():
    priors, conditional_probs = get_probs(sys.argv[1])

    for line in sys.stdin:
        line = line.strip()
        outlook, temperature, humidity, wind = line.split()

        # Calculate log-likelihood
        scores = {"Yes": math.log(priors["Yes"]), "No": math.log(priors["No"])}

        scores["Yes"] += math.log(conditional_probs.get(f"outlook:{outlook}|Yes", 1e-6))
        scores["Yes"] += math.log(
            conditional_probs.get(f"temperature:{temperature}|Yes", 1e-6)
        )
        scores["Yes"] += math.log(
            conditional_probs.get(f"humidity:{humidity}|Yes", 1e-6)
        )
        scores["Yes"] += math.log(conditional_probs.get(f"wind:{wind}|Yes", 1e-6))

        scores["No"] += math.log(conditional_probs.get(f"outlook:{outlook}|No", 1e-6))
        scores["No"] += math.log(
            conditional_probs.get(f"temperature:{temperature}|No", 1e-6)
        )
        scores["No"] += math.log(conditional_probs.get(f"humidity:{humidity}|No", 1e-6))
        scores["No"] += math.log(conditional_probs.get(f"wind:{wind}|No", 1e-6))
        for label, score in scores.items():
            print(f"{line}\t{label}:{score}")


if __name__ == "__main__":
    mapper()
