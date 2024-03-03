package task_2;

import java.util.LinkedList;

public class Vertex {
    private int state_id;// Unique identifier for the vertex
    private LinkedList<Edge> edgeList = new LinkedList<>(); // List to store edges connected to this vertex


    // Constructor to create a new vertex with the given state ID
    public Vertex(int id) {
        state_id = id;
    }

    // Get the state ID of the vertex
    public int getStateID() {
        return state_id;
    }


    // Get the list of edges connected to this vertex
    public LinkedList <Edge> getEdgeList() {
        return edgeList;
    }

    public void setVisited(boolean b) {
    }
}