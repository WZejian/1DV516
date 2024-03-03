package task_4;

import java.util.List;

/**
 * The graph also can be generated randomly using the generateRandomGraph method in Graph
 * but here manually creates two graphs to make it more clearly presented to check the
 * method of negative cycle existing or not.
 */
public class Bellman_Ford {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("v0");
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        v0.edges = List.of(new Edge(v2, 9), new Edge(v1, 7));
        v1.edges = List.of(new Edge(v3, 15));
        v2.edges = List.of(new Edge(v3, 11));
        v3.edges = List.of(new Edge(v0,-21));  //Negative weight
        v4.edges = List.of(new Edge(v5, 8), new Edge(v6, 10));
        v5.edges = List.of(new Edge(v7, 16));
        v6.edges = List.of(new Edge(v7, 10));
        v7.edges = List.of(new Edge(v4, -19));  //Negative weight

        List<Vertex> graph_1 = List.of(v0, v1, v2, v3);
        List<Vertex> graph_2 = List.of(v4, v5, v6, v7);

        if(isNegativeCycle(graph_1, v0)) {   // Bellman-ford has been performed here.
            System.out.println("Negative cycle exists in graph_1, Bellman_ford algorithm cannot be used.");
        } else {
            System.out.println("No negative cycle exists in graph_1");
            for (Vertex v: graph_1) {
                System.out.println(v);
            }
        }

        if(isNegativeCycle(graph_2, v4)) {   //Bellman-ford has been performed here.
            System.out.println("\nNegative cycle exists in graph_2, Bellman_ford algorithm cannot be used.");
        } else {
            System.out.println("No negative cycle exists in graph_2");
            for (Vertex v: graph_2) {
                System.out.println(v);
            }
        }
    }

    /**
     * Relax all edges in the graph for v-1 times
     */
    public static void bellman_ford(List<Vertex> graph, Vertex source) {
        source.dist = 0;
        int size = graph.size();
        for (int i = 0; i < size - 1; i++) {
            for (Vertex from : graph) {
                for (Edge edge : from.edges) {
                    Vertex to = edge.linked;
                    if(from.dist != Integer.MAX_VALUE && from.dist + edge.weight < to.dist) {
                        to.dist = from.dist + edge.weight;
                        to.prev = from;
                    }
                }
            }
        }
    }

    /**
     * There is a negative cycle if relaxing an edge results in new distance of a Vertex
     * after the graph has been performed by Bellman_Ford algorithm.
     */
    public static boolean isNegativeCycle(List<Vertex> graph, Vertex source) {
        // Perform bellman_ford first.
        bellman_ford(graph, source);

        for (Vertex from : graph) {
            for (Edge edge : from.edges) {
                Vertex to = edge.linked;
                if(from.dist != Integer.MAX_VALUE && from.dist + edge.weight < to.dist) {
                    return true;
                }
            }
        }

        return false;
    }
}
