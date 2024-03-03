package task_5;

import java.util.LinkedList;

public class Vertex {
    private String nameOfCourse;// Unique identifier for the vertex
    private LinkedList<Vertex> prerequisites = new LinkedList<>(); // List to store edges connected to this vertex


    // Constructor to create a new vertex with the given state ID
    public Vertex(String name) {
        nameOfCourse = name;
    }

    // Get the state ID of the vertex
    public String getStateID() {
        return nameOfCourse;
    }


    // Get the list of edges connected to this vertex
    public LinkedList < Vertex> getPrerequisites() {
        return prerequisites;
    }

}