#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys

def reducer():
    curr_record = None
    max_score = -float('inf')
    best_label = None

    for line in sys.stdin:
        line = line.strip()
        record, label_score = line.split('\t')
        label, score = label_score.split(':')
        score = float(score)
        if curr_record == record:
            if score > max_score:
                max_score = score
                best_label = label
        else:
            if curr_record is not None:
                print(f'{curr_record}-->{best_label}')
            curr_record = record
            max_score = score
            best_label = label

    print(f'{curr_record}-->{best_label}')

if __name__ == "__main__":
    reducer()
