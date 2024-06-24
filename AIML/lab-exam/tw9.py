import numpy as np
import matplotlib.pyplot as plt

def initialize_centroids(X, k):
    """Randomly initialize k centroids from the dataset X."""
    indices = np.random.choice(X.shape[0], k, replace=False)
    centroids = X[indices]
    return centroids

def assign_clusters(X, centroids):
    """Assign each data point to the nearest centroid."""
    distances = np.sqrt(((X - centroids[:, np.newaxis])**2).sum(axis=2))
    clusters = np.argmin(distances, axis=0)
    return clusters

def update_centroids(X, clusters, k):
    """Update the centroids to be the mean of the points in each cluster."""
    new_centroids = np.array([X[clusters == i].mean(axis=0) for i in range(k)])
    return new_centroids

def k_means(X, k, max_iters=100):
    """Run the k-means algorithm."""
    centroids = initialize_centroids(X, k)
    for _ in range(max_iters):
        clusters = assign_clusters(X, centroids)
        new_centroids = update_centroids(X, clusters, k)
        if np.all(centroids == new_centroids):
            break
        centroids = new_centroids
    return centroids, clusters

def plot_clusters(X, clusters, centroids):
    """Plot the clusters and their centroids."""
    plt.scatter(X[:, 0], X[:, 1], c=clusters, cmap='viridis')
    plt.scatter(centroids[:, 0], centroids[:, 1], s=100, c='red')
    plt.show()

# Example usage:
# Generate some example data
from sklearn.datasets import make_blobs
X, _ = make_blobs(n_samples=300, centers=4, cluster_std=0.60, random_state=0)

# Run k-means
k = 4
centroids, clusters = k_means(X, k)
print("Final centroids:\n", centroids)
# Plot the results
plot_clusters(X, clusters, centroids)
