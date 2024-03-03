package task_2;

import java.util.List;

public class Task2Main {
    public static void main(String[] args) {
        Graph graph =new UndirectedGraph();
        Graph graph2 =new DirectGraph();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9= new Vertex(9);
        Vertex vertex10 = new Vertex(10);

        // undirected graph
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);

        // directed graph
        graph2.addVertex(vertex6);
        graph2.addVertex(vertex7);
        graph2.addVertex(vertex8);
        graph2.addVertex(vertex9);
        graph2.addVertex(vertex10);


        // undirected graph
        graph.addEdgeByID(1, 2, 1);
        graph.addEdgeByID(2, 3, 3);
        graph.addEdgeByID(1, 4, 1);
        graph.addEdgeByID(4, 5, 2);
        graph.addEdgeByID(3, 4, 2);

        // directed graph
        graph2.addEdgeByID(6, 7, 1);
        graph2.addEdgeByID(7, 9, 3);
        graph2.addEdgeByID(8, 6, 1);
        graph2.addEdgeByID(8, 10, 2);

      // undirected graph
        System.out.println("BFS  Undirected graph ");
        if(graph.isPathExistsBFS(1,4)){
            List<Integer> v = graph.findPathBFS(1, 4);
            for ( int i = 0; i<v.size(); i++){
                System.out.println(v.get(i));
            }

        }
        else {
            System.out.println("this path does not exist");
        }


        System.out.println("DFS Undirected graph  ");
        if (graph.isPathExistsDFS(1,4)) {
            List<Integer> v2 = graph.findPathDFS(1, 4);
            for (int i = 0; i < v2.size(); i++) {
                System.out.println(v2.get(i));
            }
        }



        System.out.println("BFS Directed graph ");
        if(graph2.isPathExistsBFS(6,10)){
            List<Integer> v3 = graph2.findPathBFS(6, 10);
            for ( int i = 0; i<v3.size(); i++){
                System.out.println(v3.get(i));
            }

        }
        else {
            System.out.println("this path does not exist");
        }

        System.out.println("DFS Directed graph  ");
        if (graph2.isPathExistsDFS(6,10)) {
            List<Integer> v4 = graph2.findPathDFS(6, 10);
            for (int i = 0; i < v4.size(); i++) {
                System.out.println(v4.get(i));
            }
        }
        else {
            System.out.println("this path does not exist");
        }

        System.out.println("Print Graph Operation -");
        graph.showGraph();


}
}