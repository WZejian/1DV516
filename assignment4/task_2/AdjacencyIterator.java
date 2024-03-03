package task_2;

import java.util.Iterator;

public class AdjacencyIterator implements Iterator <Vertex> {
    private Graph gr; // Reference to the graph
    private Iterator<Edge> edgeIterator; // Iterator for the edges of the vertex


    public AdjacencyIterator(Graph gr, Vertex v) {
        this.gr = gr; // Initialize the graph reference
        edgeIterator = v.getEdgeList().iterator(); // Initialize the edge iterator for the provided vertex

    }

    @Override
    public boolean hasNext() {
        return edgeIterator.hasNext(); // Check if there are more adjacent vertices to visit
    }

    @Override
    public Vertex next() {
        Edge edge = edgeIterator.next();// Get the next edge
        return gr.getVertexByID(edge.getDestinationVertexID()); // Return the adjacent vertex

    }
}
