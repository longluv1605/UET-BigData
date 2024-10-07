#!/usr/bin/env python3
# -*-coding:utf-8 -*
import sys
import math


# Calculate euclid distance
def euclidean_distance(point, centroid):
    return math.sqrt((point[0] - centroid[0]) ** 2 + (point[1] - centroid[1]) ** 2)


# Get initial centroids
def getCentroids(filepath):
    centroids = []

    with open(filepath, 'r') as fp:
        for line in fp.readlines():
            line = line.strip()
            cord = line.split(",")
            centroids.append([float(cord[0]), float(cord[1])])

    fp.close()
    return centroids


def map():
    init_centroids = getCentroids(sys.argv[1])

    for line in sys.stdin:
        line = line.strip()
        point_id, x, y = line.split(",")
        point = (float(x), float(y))

        # Find closest centroid
        nearest_centroid = None
        min_dist = float("inf")
        for i, centroid in enumerate(init_centroids):
            dist = euclidean_distance(point, centroid)
            if dist < min_dist:
                min_dist = dist
                nearest_centroid = i  # Note that we save the id of the centroid

        print(f"{nearest_centroid}\t{point_id},{x},{y}")


if __name__ == "__main__":
    map()
