package task_1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Undirected Graph");
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9 = new Vertex(9);
        Vertex vertex10 = new Vertex(10);

        System.out.println("Adding vertices");
        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addVertex(vertex3);
        undirectedGraph.addVertex(vertex4);
        undirectedGraph.addVertex(vertex5);
        undirectedGraph.addVertex(vertex6);
        undirectedGraph.addVertex(vertex7);
        undirectedGraph.addVertex(vertex8);
        undirectedGraph.addVertex(vertex9);
        undirectedGraph.addVertex(vertex10);
        undirectedGraph.showGraph();

        System.out.println("Delete vertices");
        undirectedGraph.deleteVertexByID(9);
        undirectedGraph.deleteVertexByID(10);
        undirectedGraph.showGraph();

        System.out.println("Add Edge with weight");
        undirectedGraph.addEdgeByID(1,2,3);
        undirectedGraph.addEdgeByID(2,3,4);
        undirectedGraph.addEdgeByID(3,4,5);
        undirectedGraph.addEdgeByID(4,5,6);
        undirectedGraph.addEdgeByID(1,3,8);
        undirectedGraph.addEdgeByID(1,4,7);
        undirectedGraph.showGraph();


        System.out.println("Update Edge Operation");
        undirectedGraph.updateEdgeByID(1,2,10);
        undirectedGraph.updateEdgeByID(2,3,7);
        undirectedGraph.showGraph();

        System.out.println("Add Edge Operation (Default Weight 1.0) -");
        undirectedGraph.addEdgeByIDDef(7,8);
        undirectedGraph.showGraph();

        System.out.println("Delete Edge Operation -");
        undirectedGraph.deleteEdgeByID(1,2);
        undirectedGraph.deleteEdgeByID(2,3);
        undirectedGraph.showGraph();


        System.out.println("Total number of edges in the graph  " + undirectedGraph.totalNumberofEdges());
        System.out.println("Total number of vertices (nodes) in the grap  " + undirectedGraph.totalNumberOfVerticies());

        System.out.println("Iterator by vertex  ");
        Iterator<Vertex> it = undirectedGraph.iteratorByVertex();
        while (it.hasNext()) {
            Vertex v = it.next();
            System.out.println(v.getStateID());

        }

        System.out.println("Iterator by edges  ");
        Iterator<Edge> it2 = undirectedGraph.iteratorEdge();
        while (it2.hasNext()) {
            Edge e = it2.next();
            System.out.println(e.getDestinationVertexID());
        }

        System.out.println("Iterator by the adjacency of a provided vertex");
        Iterator<Vertex> adjIterator = undirectedGraph.iteratorAdjacencyVertex(1);
        while (adjIterator.hasNext()) {
            Vertex v = adjIterator.next();
            System.out.println(v.getStateID());
        }

        System.out.println("Degree of the vertex: ");

            int degree= undirectedGraph.getDegree(3);
            System.out.println("Vertex 3 " + " has "+ degree + " degree");


        System.out.println();
        System.out.println("Directed Graph");
        DirectGraph directedGraph = new DirectGraph();


        Vertex vertex11 = new Vertex(11);
        Vertex vertex12 = new Vertex(12);
        Vertex vertex13 = new Vertex(13);
        Vertex vertex14 = new Vertex(14);
        Vertex vertex15 = new Vertex(15);
        Vertex vertex16 = new Vertex(16);
        Vertex vertex17 = new Vertex(17);
        Vertex vertex18 = new Vertex(18);
        Vertex vertex19 = new Vertex(19);
        Vertex vertex20 = new Vertex(20);

        System.out.println("Adding vertices");
        directedGraph.addVertex(vertex11);
        directedGraph.addVertex(vertex12);
        directedGraph.addVertex(vertex13);
        directedGraph.addVertex(vertex14);
        directedGraph.addVertex(vertex15);
        directedGraph.addVertex(vertex16);
        directedGraph.addVertex(vertex17);
        directedGraph.addVertex(vertex18);
        directedGraph.addVertex(vertex19);
        directedGraph.addVertex(vertex20);
        directedGraph.showGraph();

        System.out.println("Delete vertices");
        directedGraph.deleteVertexByID(19);
        directedGraph.deleteVertexByID(20);
        directedGraph.showGraph();

        System.out.println("Add Edge with weight");
        directedGraph.addEdgeByID(11,12,5);
        directedGraph.addEdgeByID(12,13,6);
        directedGraph.addEdgeByID(13,11,1);
        directedGraph.addEdgeByID(13,14,7);
        directedGraph.addEdgeByID(14,15,8);
        directedGraph.addEdgeByID(15,16,2);
        directedGraph.addEdgeByID(16,14,3);
        directedGraph.showGraph();


        System.out.println("Update Edge Operation");
        directedGraph.updateEdgeByID(11,12,14);
        directedGraph.updateEdgeByID(12,13,15);
        directedGraph.showGraph();

        System.out.println("Add Edge Operation (Default Weight 1.0) -");
        directedGraph.addEdgeByIDDef(16,17);
        directedGraph.addEdgeByIDDef(17,18);
        directedGraph.showGraph();



        System.out.println("Delete Edge");
        directedGraph.deleteEdgeByID(17,18);
        directedGraph.showGraph();


        System.out.println("Total number of edges in the graph  " + directedGraph.totalNumberofEdges());
        System.out.println("Total number of vertices (nodes) in the grap  " + directedGraph.totalNumberOfVerticies());


        System.out.println("Iterator by vertex  ");
        Iterator<Vertex> it1 = directedGraph.iteratorByVertex();
        while (it1.hasNext()) {
            Vertex v = it1.next();
            System.out.println(v.getStateID());

        }

        System.out.println("Iterator by edges  ");
        Iterator<Edge> it_2 = directedGraph.iteratorEdge();
        while (it_2.hasNext()) {
            Edge e = it_2.next();
            System.out.println(e.getDestinationVertexID());
        }

        System.out.println("Iterator by the adjacency of a provided vertex");
        Iterator<Vertex> adjIterator1 = directedGraph.iteratorAdjacencyVertex(11);
        while (adjIterator1.hasNext()) {
            Vertex v = adjIterator1.next();
            System.out.println(v.getStateID());
        }


        System.out.println("Degree of the vertex");

        int outDegree = directedGraph.getOutDegree(11);
        int inDegree = directedGraph.getInDegree(14);
        System.out.println("11" + " has "+ "out degree " + outDegree);
        System.out.println("14" + " has "+ "in degree " + inDegree);

    }
    }

