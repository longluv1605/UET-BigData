#!/usr/bin/env python3
# -*-coding:utf-8 -*

import sys


def reduce():
    current_centroid = None
    current_points = []

    for line in sys.stdin:
        line = line.strip()
        centroid, point = line.split("\t")
        point_id, x, y = point.split(",")
        x, y = float(x), float(y)

        if current_centroid == centroid:  # Check if still same point group
            current_points.append((x, y))
        else:
            if current_centroid is not None:  # Mean that we got new point group
                # Emit the new centroid of previous group
                mean_x = sum([p[0] for p in current_points]) / len(current_points)
                mean_y = sum([p[1] for p in current_points]) / len(current_points)
                print(f"{current_centroid}\t{mean_x},{mean_y}")

            # Re-init these two variables
            current_centroid = centroid
            current_points = [(x, y)]

    # Emit the last group's new centroid
    if current_centroid:
        mean_x = sum([p[0] for p in current_points]) / len(current_points)
        mean_y = sum([p[1] for p in current_points]) / len(current_points)
        print(f"{current_centroid}\t{mean_x},{mean_y}")


if __name__ == "__main__":
    reduce()
