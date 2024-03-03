package task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    private List<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    /**
     * Generate random graph with edges with non-negative weight.
     */
    public static Graph generateRandomGraph(int VertexNum, int maxWeight) {
        Graph graph = new Graph();
        Random random = new Random();

        // Add vertices to the graph
        for (int i = 0; i < VertexNum; i++) {
            Vertex v = new Vertex("V" + i);
            v.edges = new ArrayList<>();
            graph.addVertex(v);
        }

        // Generate random number of edges with random weight for each vertex
        for (int i = 0; i < VertexNum; i++) {
            Vertex curr = graph.getVertices().get(i);
            int numEdges = random.nextInt(VertexNum/2) + 1;
            //int numEdges = VertexNum - 1;
            for (int j = 0; j < numEdges; j++) {
                Vertex rndVertex;
                do {
                    int rndVertexIdx = random.nextInt(VertexNum);
                    rndVertex = graph.getVertices().get(rndVertexIdx);
                } while (rndVertex == curr || isDirected(curr, rndVertex));

                int weight = random.nextInt(maxWeight) + 1;
                Edge edge = new Edge(rndVertex, weight);
                curr.edges.add(edge);
            }
        }

        return graph;
    }

    /**
     * Checks if vertex v1 points to v2.
     */
    private static boolean isDirected(Vertex v1, Vertex v2) {
        for (Edge edge : v1.edges) {
            if (edge.linked == v2) {
                return true;
            }
        }

        return false;
    }



}
