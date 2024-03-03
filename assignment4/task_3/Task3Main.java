package task_3;

import java.util.List;

public class Task3Main {
    public static void main(String[] args) {
        UndirectedGraph graph= new UndirectedGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));
        graph.addVertex(new Vertex(5));
        graph.addVertex(new Vertex(6));
        graph.addVertex(new Vertex(7));
        graph.addVertex(new Vertex(8));
        graph.addVertex(new Vertex(9));
        graph.addVertex(new Vertex(10));


        graph.addEdge(0,1,2);
        graph.addEdge(0,3,1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 6);
        graph.addEdge(3, 5, 7);
        graph.addEdge(4, 5, 8);

        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 2);
        graph.addEdge(7, 8, 1);
        graph.addEdge(8, 9, 3);
        graph.addEdge(7, 9, 5);
        graph.addEdge(8, 10, 6);
        graph.addEdge(10, 9, 7);


        List<MST> listMst =graph.buildOfTrees();
         int index = 1;
        for (MST mst: listMst){
            System.out.println("The tree " + index);
            index ++;

            for (Edge edge: mst.getEdge()){
                System.out.println("Edges :" + edge.getSource()+ "--" + edge.getDestinationVertexID() + " weight "+ (edge.getWeight()));
            }
        }

    }
}




