# -- coding: utf-8 --
"""
Created on Sun Jun 23 09:48:39 2024

@author: Asus
"""

# -- coding: utf-8 --
"""
Created on Sat Jun 22 22:11:14 2024

@author: Asus
"""
#tw3
def astar(graph, start, goal, heuristic):
    # Queue for nodes to be explored
    queue = [(start, [])]  # (node, path)
    # Cost to reach each node from start
    cost_so_far = {start: 0}
    # Counter for iteration step
    iteration_step = 0
    
    while queue:
        iteration_step += 1
        # Get the node to explore next
        current, path = queue.pop(0)
        
        print("Iteration", iteration_step, "- Current node:", current, "- Path:", path)
        
        # Goal reached, return the path
        if current == goal:
            return path + [current], iteration_step
        
        # Explore neighbors
        for neighbor, cost in graph[current].items():
            new_cost = cost_so_far[current] + cost
            # Update cost if the new path is cheaper or this is the first time visiting the node
            if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:
                cost_so_far[neighbor] = new_cost
                queue.append((neighbor, path + [current]))
                print("   -> Neighbor:", neighbor, "- Path:", path + [current], "- Cost:", new_cost)
    
    # No path found
    return None, iteration_step

# Example graph represented as an adjacency list with costs
graph = {
    'A': {'B': 1, 'C': 3},
    'B': {'D': 3, 'E': 4},
    'C': {'F': 2},
    'D': {},
    'E': {'G': 5},
    'F': {},
    'G': {}
}

# Heuristic values for each node
heuristic = {
    'A': 10,
    'B': 5,
    'C': 8,
    'D': 4,
    'E': 3,
    'F': 2,
    'G': 6
}

start_node = 'A'
goal_node = 'G'

# Perform A* search
path, iterations = astar(graph, start_node, goal_node, heuristic)

# Print the result
if path:
    print("Path found:", path)
    total_cost = sum(graph[path[i]][path[i+1]] for i in range(len(path)-1))
    print("Total cost:", total_cost)
else:
    print("No path found.")

print("Iterations:",iterations)