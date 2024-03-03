package task_1;

public class UndirectedGraph extends Graph {

    // add edge
    @Override
    protected void addEdge(int fromVertex, int toVertex, double weight) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == fromVertex) {
                Edge e = new Edge(toVertex, weight);

                vertex.getEdgeList().add(e);

            } else if (vertex.getStateID() == toVertex) {
                Edge e = new Edge(fromVertex, weight);
                vertex.getEdgeList().add(e);

            }
        }
    }

    // update edge
    @Override
    protected void updateEdge(int fromVertex, int toVertex, double weight) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == fromVertex) {
                for (Edge edge: vertex.getEdgeList()) {
                    if (edge.getDestinationVertexID() == toVertex) {
                        edge.setWeight(weight);
                        break;
                    }
                }
            } else if (vertex.getStateID() == toVertex) {
                for (Edge edge: vertex.getEdgeList()) {
                    if (edge.getDestinationVertexID() == fromVertex) {
                        edge.setWeight(weight);
                        break;
                    }
                }
            }
        }

    }

    // Get the degree of a vertex by its ID
    public int getDegree(int vertexID) {
        Vertex vertex = getVertexByID(vertexID);

        if (vertex == null) {
            throw new RuntimeException("Vertex with ID " + vertexID + " does not exist.");
        }

        return vertex.getEdgeList().size();
    }


    // total number of edges
    @Override
    public int totalNumberofEdges() {
        return super.totalNumberofEdges()/2;
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
}
