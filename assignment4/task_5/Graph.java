package task_5;

import java.util.LinkedList;

public abstract class Graph {

    // List to store vertices in the graph
    protected LinkedList<Vertex> vertices = new LinkedList<>();

    // Check if a vertex with the given ID exists in the graph
    public boolean checkIfVertexExistByID(String name) {
        boolean flag = false;
        for (Vertex vertex: vertices) {
            if (vertex.getStateID().equals(name) ) {
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
    public Vertex getVertexByID(String name) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID().equals(name)) {
                return vertex;
            }
        }
        return null;
    }


    // Add an edge between two vertices
    protected abstract void addEdge (String fromVertex, String toVertex);


    public void addEdgeByID(String fromVertex, String toVertex) {
        boolean check1 = checkIfVertexExistByID(fromVertex);
        boolean check2 = checkIfVertexExistByID(toVertex);
        if ((check1 && check2 == true)) {
                addEdge(fromVertex, toVertex);
        } else {
             throw  new RuntimeException("Invalid Vertex ID entered");
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
           count += vertex.getPrerequisites().size();

        }
        return count;
    }

    // Display the graph's structure
    public void show(){
        for ( Vertex vertex: vertices){
            System.out.print(vertex.getStateID() + " : ");
            for (Vertex v: vertex.getPrerequisites()){
                System.out.print(v.getStateID()+ " ");
            }
            System.out.println();
        }
    }

    // Delete a vertex from the graph by its ID
    public void deleteVertexByID(String name) {
        for (Vertex vertex: vertices) {
            for (Vertex v: vertex.getPrerequisites()) {
                if (v.getStateID().equals(name)) {
                    vertex.getPrerequisites().remove(v);
                    break;
                }
            }
        }
        for (Vertex vertex: vertices){
            if ( vertex.getStateID().equals(name)){
                vertices.remove(vertex);
                break;

            }
    }
}
}
