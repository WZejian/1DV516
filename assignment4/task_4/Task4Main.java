package task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task4Main {
    public static void main(String[] args) {
        MethodTimer timer = new MethodTimer();
        Random random = new Random();

        int numOfGraph = 10;
        for (int i = 0; i < numOfGraph; i++) {
            int verticesNum = random.nextInt(50) + 50 ;
            int maxWeight = random.nextInt(100) + 100;
            System.out.println("------------------------------------------------------");
            System.out.println("Graph_" + i);
            Graph g = Graph.generateRandomGraph(verticesNum, maxWeight);
            // Prints the generated graph
            List<Vertex> vertices = g.getVertices();
            Vertex source = vertices.get(0);
            int numOfVertices = vertices.size();

            List<Vertex> clonedVertices_1 = new ArrayList<>(vertices);
            List<Vertex> clonedVertices_2 = new ArrayList<>(vertices);

            double dijkstra_time = timer.measureTime(() -> {
                Dijsktra.dijkstra(clonedVertices_1, source);
            });

            System.out.print("Dijkstra: ");
            for(Vertex v: clonedVertices_1) {
                System.out.print(v + "; ");
            }

            double bf_time  = timer.measureTime(() -> {
                Bellman_Ford.bellman_ford(clonedVertices_2, source);
            });

            System.out.println();
            System.out.print("Bellman-Ford: ");
            for(Vertex v: clonedVertices_2) {
                System.out.print(v + "; ");
            }

            System.out.println("\nVertices number in graph_" + i + ": " + numOfVertices);
            System.out.println("Time for Dijkstra for graph_" + i + " is " + dijkstra_time + " nanoseconds.");
            System.out.println("Time for Bellman_Ford for graph_" + i + " is " + bf_time + " nanoseconds.");

        }

    }
}
