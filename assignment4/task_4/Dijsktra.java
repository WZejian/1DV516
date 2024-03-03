package task_4;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra cannot perform graph with negative weight edge, so there are no negative weight
 * edges in the randomly generated graph when performing Dijkstra algorithm.
 * If the result shows that in a graph some vertices' distances are 2147483647, it means that
 * these vertices cannot be reached from the source vertex.
 */
public class Dijsktra {
    public static void main(String[] args) {

        int numVertices = 7;
        int maxWeight = 10;

        Graph graph = Graph.generateRandomGraph(numVertices, maxWeight);
        for (Vertex v : graph.getVertices()) {
            System.out.print(v.getName() + " -- ");
            for (Edge edge : v.edges) {
                System.out.print(edge.linked.getName() + "[" + edge.weight + "] ");
            }
            System.out.println();
        }

        List<Vertex> vertices = graph.getVertices();
        dijkstra(vertices, vertices.get(0));  // Lets the first vertex in the list be the source vertex.
        for(Vertex v: vertices) {
            System.out.println(v);
        }
    }


    /**
     * Using minHeap to take the vertex of minimum distance which locates first in the minHeap.
     */
    public static void dijkstra(List<Vertex> vertices, Vertex source) {
        // PriorityQueue is based on min heap.
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
        source.dist = 0;   //Distance of source vertex is 0, other vertices' are infinite.
        minHeap.offer(source);

        while (!minHeap.isEmpty()) {
            Vertex curr = minHeap.poll();
            if(!curr.visited) {
                for(Edge edge: curr.edges) {
                    Vertex to = edge.linked;
                    int newDist = curr.dist + edge.weight;
                    if(newDist < to.dist) {
                        minHeap.remove(to);
                        to.dist = newDist;
                        to.prev = curr;
                        minHeap.offer(to);
                    }
                }
                curr.visited = true;
            }

        }
    }


}
