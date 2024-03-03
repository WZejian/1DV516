package task_3;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Graph {
    protected LinkedList<Vertex> vertices = new LinkedList<>(); // List to store vertices in the graph


    // Check if a vertex with the given ID exists in the graph
    public boolean checkIfVertexExistByID(int vid) {
        boolean flag = false;
        for (Vertex vertex: vertices) {
            if (vertex.getStateID()== vid) {
                return true;
            }
        }
        return false;
    }


    // Add a new vertex to the graph
    public  void addVertex(Vertex newVertex) {
        boolean check = checkIfVertexExistByID(newVertex.getStateID());
        if (check == true) {
             System.out.println("Vertex with this ID already exist"); ;
        } else {
            vertices.add(newVertex);
        }
    }
    // Get a vertex in the graph by its ID
    Vertex getVertexByID(int vid) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == vid) {
                return vertex;
            }
        }
        return null;
    }


    // Check if an edge with a specific source and destination vertex ID exists in the graph
    public boolean checkIfEdgeExistByID(int fromVertex, int toVertex) {
        Vertex v = getVertexByID(fromVertex);
        LinkedList <Edge> e = v.getEdgeList();
        for (Edge edge: e) {
            if (edge.getDestinationVertexID() == toVertex) {
                return true;
            }
        }
        return false;
    }


    // Add an edge with a default weight of 1.0 between two vertices based on their IDs
    public void addEdgeByIDDef(int fromVertex, int toVertex) {
        addEdgeByID(fromVertex, toVertex, 1); // Default weight is 1.0
    }

    // Add an edge with weight
    protected abstract void addEdge (int fromVertex, int toVertex, double weight);


    public void addEdgeByID(int fromVertex, int toVertex, double weight) {
        boolean check1 = checkIfVertexExistByID(fromVertex);
        boolean check2 = checkIfVertexExistByID(toVertex);
        boolean check3 = checkIfEdgeExistByID(fromVertex, toVertex);

        if ((check1 && check2 == true)) {
            if (check3 == true) {
                throw new RuntimeException("this edge already exists");

            } else {
                addEdge(fromVertex, toVertex, weight);

             }
        } else {
             throw  new RuntimeException("Invalid Vertex ID entered");
       }
     }


    // Update edge
    protected abstract void updateEdge (int fromVertex, int toVertex, double weight);

    // Update the weight of an existing edge between two vertices
    public void updateEdgeByID(int fromVertex, int toVertex, double newWeight) {
        boolean check = checkIfEdgeExistByID(fromVertex, toVertex);
        if (check == true) {
            updateEdge(fromVertex, toVertex, newWeight);
        } else {
            System.out.println("edge does not exist between vertices");
        }
    }

    // Delete edge
    protected abstract void deleteEdge (int fromVertex, int toVertex);

    // Delete an edge between two vertices
    public void deleteEdgeByID(int fromVertex, int toVertex) {
        boolean check = checkIfEdgeExistByID(fromVertex, toVertex);
        if (check == true) {
            deleteEdge(fromVertex, toVertex);
            }


    }

    // Get the total number of vertices in the graph
    public int totalNumberOfVerticies(){
        return vertices.size();

    }

    // Get the total number of edges in the graph
    public int totalNumberofEdges (){
         int count = 0;
        for (Vertex vertex: vertices ){
           count += vertex.getEdgeList().size();

        }
        return count;
    }

    // Display graph
    public void showGraph(){
        for (Vertex vertex: vertices){
            System.out.print(vertex.getStateID()+ " --- ");
            for (Edge edge: vertex.getEdgeList()){
                System.out.print(edge.getDestinationVertexID()+ " (" + edge.getWeight() + "), ");

            }
            System.out.println( );
        }
    }


    // Get an iterator for iterating through vertices
    public Iterator <Vertex> iteratorByVertex(){
        return vertices.iterator();
    }

    // Get an iterator for iterating through edges
    public Iterator <Edge> iteratorEdge (){
        return new EdgeIterator(vertices);
    }

    // Get an iterator for iterating through adjacency vertices of a specific vertex
     public Iterator <Vertex> iteratorAdjacencyVertex(int id){
        Vertex v = getVertexByID(id);
        if ( v==null){
            throw new RuntimeException("vertex does not exist");
        }else {
            return new AdjacencyIterator(this,v);
        }
     }


    // Delete a vertex from the graph by its ID
    public void deleteVertexByID(int vid) {
        for (Vertex vertex: vertices) {
            for (Edge edge: vertex.getEdgeList()) {
                if (edge.getDestinationVertexID() == vid) {
                    vertex.getEdgeList().remove(edge);
                    break;
                }
            }
        }
        for (Vertex vertex: vertices){
            if ( vertex.getStateID()== vid){
                vertices.remove(vertex);
                break;

            }
    }
}
}
