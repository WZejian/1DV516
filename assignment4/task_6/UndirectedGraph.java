package task_6;

public class UndirectedGraph extends Graph {
    // Adds edge
    @Override
    protected void addEdge(int fromVertex, int toVertex) {
        for (Vertex vertex : vertices) {
            if (vertex.getStateID() == fromVertex) {
                Edge e = new Edge(toVertex);

                vertex.getEdgeList().add(e);

            } else if (vertex.getStateID() == toVertex) {
                Edge e = new Edge(fromVertex);
                vertex.getEdgeList().add(e);

            }
        }
    }

    // delete edge
    @Override
    protected void deleteEdge(int fromVertex, int toVertex) {
        for (Vertex vertex : vertices) {
            if (vertex.getStateID() == fromVertex) {
                for (Edge edge : vertex.getEdgeList()) {
                    if (edge.getDestinationVertexID() == toVertex) {
                        vertex.getEdgeList().remove(edge);
                        break;
                    }
                }
            }
            if (vertex.getStateID() == toVertex) {
                for (Edge edge : vertex.getEdgeList()) {
                    if (edge.getDestinationVertexID() == fromVertex) {
                        vertex.getEdgeList().remove(edge);
                        break;
                    }
                }
            }
        }
    }

    // Creates a copy of the current graph, including vertices and edges.
    public UndirectedGraph copyGraph() {
        UndirectedGraph graph = new UndirectedGraph();
        for (Vertex vertex : vertices) {
            Vertex copyVertex = new Vertex(vertex.getStateID());
            for (Edge edge : vertex.getEdgeList()) {
                Edge copyEdge = new Edge(edge.getDestinationVertexID());
                copyVertex.getEdgeList().add(copyEdge);
            }
            graph.vertices.add(copyVertex);

        }
        return graph;
    }

    // Checks if removing an edge between two specified vertices would result in a disconnected graph
    public boolean checkBridge(int id1, int id2) {
        if (getVertexByID(id1) == null || getVertexByID(id2) == null) {
            throw new RuntimeException("Vertex not found in the graph");
        }

        // Create a copy of the graph to perform edge removal and check connectivity
        UndirectedGraph copyGraph = this.copyGraph();

        // Check if there is a path between the two vertices before removing the edge
        if (copyGraph.isPathExistsDFS(id1, id2)) {
            // Remove the edge between id1 and id2 in the copied graph
            copyGraph.deleteEdge(id1,id2);
                // Check if there is still a path between the two vertices after removing the edge
            if (!copyGraph.isPathExistsDFS(id1, id2)) {
                return true; // The edge is a bridge
            }

            }
        return false; // The edge is not a bridge
    }

}
