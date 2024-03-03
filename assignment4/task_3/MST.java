package task_3;

import java.util.*;

import static task_3.Union.union;


public class MST {
    private List<Edge>edge = new ArrayList<>();

    public MST(List<Edge> edge) {
        this.edge = edge;
    }

    public List<Edge> getEdge() {
        return edge;
    }

    static class DisjointSet {
        int parent;
        int height;

        // Constructor for the DisjointSet class
        // The parent field helps track the relationship between elements
        // height field is used for optimization to ensure balanced trees when performing union operations.
        // disjoint sets are crucial for detecting and avoiding cycles when building the minimum spanning tree.
        public DisjointSet(int parent, int height) {
            this.parent = parent;
            this.height = height;
        }
    }


    //Find the minimum spanning tree using Kruskal's algorithm.
    static MST findMinimumSpanningTree(int numVertices, List<Edge> edges) {
        List<Edge> mstEdges = new ArrayList<>(); // Store edges of the MST
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a.getWeight())); // Priority queue to maintain edges sorted by weight
        MST.DisjointSet[] subsets = new MST.DisjointSet[numVertices]; // Disjoint set data structure to manage sets

        // Initialize disjoint sets, each element as its own set
        for (int i = 0; i < numVertices; i++) {
            subsets[i] = new MST.DisjointSet(i, 0);
        }

        // Add all edges to the minHeap for sorting
        for (Edge edge : edges) {
            minHeap.offer(edge);
        }

        // Continue until MST has numVertices - 1 edges or no more edges in the heap
        while (mstEdges.size() < numVertices - 1 && !minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll(); // Get the edge with the minimum weight
            int x = Union.findRoot(subsets, currentEdge.getSource());
            int y = Union.findRoot(subsets, currentEdge.getDestinationVertexID());

            // Check if adding this edge creates a cycle or not
            if (x != y) {
                mstEdges.add(currentEdge); // Include this edge in the MST
                union(subsets, x, y); // Merge the sets of x and y
            }
        }
        return new MST(mstEdges); // Return the edges of the MST
    }


}
