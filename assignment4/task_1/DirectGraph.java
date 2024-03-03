package task_1;

public class DirectGraph extends Graph{

    // out coming degree
    public int getOutDegree(int vertexID) {
        Vertex vertex = getVertexByID(vertexID);

        if (vertex == null) {
            throw new RuntimeException("Vertex with ID " + vertexID + " does not exist.");
        }

        return vertex.getEdgeList().size();
    }


    // in coming degree
    public int getInDegree(int vertexID) {
        Vertex vertex = getVertexByID(vertexID);

        if (vertex == null) {
            throw new RuntimeException("Vertex with ID " + vertexID + " does not exist.");
        }
        int count=0;
        for (Vertex v: vertices) {
            for( Edge edge: v.getEdgeList() ){
                if(edge.getDestinationVertexID() == vertexID){
                    count++;

                }
            }

        }
        return count;
    }

    // add edge
    @Override
    protected void addEdge(int fromVertex, int toVertex, double weight) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == fromVertex) {
                Edge e = new Edge(toVertex, weight);
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

        }
    }
}
