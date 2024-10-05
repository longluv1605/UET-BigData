#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys

def mapper():
    for line in sys.stdin:
        line = line.strip()
        outlook, temperature, humidity, wind, play_tennis = line.split()

        # Emit the label count
        print(f"label:{play_tennis}\t1")

        # Emit the feature counts conditioned on the label
        print(f"outlook:{outlook}|{play_tennis}\t1")
        print(f"temperature:{temperature}|{play_tennis}\t1")
        print(f"humidity:{humidity}|{play_tennis}\t1")
        print(f"wind:{wind}|{play_tennis}\t1")

if __name__ == "__main__":
    mapper()
