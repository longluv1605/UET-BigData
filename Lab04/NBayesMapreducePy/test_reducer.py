#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys

def reducer():
    current_label = None
    max_score = -float('inf')
    best_label = None

    for line in sys.stdin:
        line = line.strip()
        label, score = line.split('\t')
        score = float(score)

        if score > max_score:
            max_score = score
            best_label = label

    print(f"Predicted label: {best_label}")

if __name__ == "__main__":
    reducer()
