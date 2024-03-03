package task_6;

public class Task6Main {
    public static void main(String[] args) {

        UndirectedGraph graph = new UndirectedGraph();

        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);

        // Add the Vertex objects to the graph
        //graph.addVertex(vertex0);
        //graph.addVertex(vertex1);
        //graph.addVertex(vertex2);
        //graph.addVertex(vertex3);
        //graph.addVertex(vertex4);


        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);


        // Add edges (customize as needed)
        //graph.addEdgeByID(0, 1, 2);
        //graph.addEdgeByID(1, 2, 1);
        //graph.addEdgeByID(2, 3, 3);
        //graph.addEdgeByID(3, 4, 2);

        graph.addEdgeByID(1, 2);
        graph.addEdgeByID(1, 3);
        graph.addEdgeByID(2, 3);

        graph.addEdgeByID(3, 4);
        graph.addEdgeByID(4, 5);
        graph.addEdgeByID(5, 6);
        graph.addEdgeByID(6, 7);
        graph.addEdgeByID(7, 8);
        graph.addEdgeByID(4, 8);
        graph.addEdgeByID(5, 8);


        // Specify the edge you want to check
        int edgeSource = 5;
        int edgeDestination = 6;

        // Check if the specified edge is a bridge
        boolean isBridge = graph.checkBridge(edgeSource, edgeDestination);

        if (isBridge) {
            System.out.println("The edge (" + edgeSource + " - " + edgeDestination + ") is a bridge.");
        } else {
            System.out.println("The edge (" + edgeSource + " - " + edgeDestination + ") is not a bridge.");
        }
    }
}
