#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys

def reducer():
    current_key = None
    current_count = 0

    for line in sys.stdin:
        line = line.strip()
        key, count = line.split('\t')
        count = int(count)

        if current_key == key:
            current_count += count
        else:
            if current_key:
                # Output the count for the previous key
                print(f"{current_key}\t{current_count}")
            current_key = key
            current_count = count

    # Output the last key
    if current_key == key:
        print(f"{current_key}\t{current_count}")

if __name__ == "__main__":
    reducer()
