package task_1;

import java.util.Iterator;
import java.util.LinkedList;

public class EdgeIterator implements Iterator <Edge>  {
    private Iterator<Vertex> vertexIterator;  // Iterator for vertices in the graph
    private Iterator<Edge> iteratorEdge;      // Iterator for edges of the current vertex
    private Vertex vertex;


    // Constructor to initialize the EdgeIterator
    public EdgeIterator(LinkedList<Vertex> v) {
        vertexIterator = v.iterator(); // Initialize the vertex iterator
        vertex=vertexIterator.next();  // Get the first vertex from the iterator
        iteratorEdge= vertex.getEdgeList().iterator(); // Initialize the edge iterator
    }

    @Override
    // Check if there are more vertices or edges to iterate through
    public boolean hasNext() {
        if (iteratorEdge.hasNext())
        return true;
        if (!vertexIterator.hasNext())
            return false;
        while(vertexIterator.hasNext()){
            vertex = vertexIterator.next();
            iteratorEdge = vertex.getEdgeList().iterator();
            if (iteratorEdge.hasNext() == true){
                return true;
            }
        }
        return false;
    }

    @Override
    public Edge next() {
        return iteratorEdge.next();
    }


    }

