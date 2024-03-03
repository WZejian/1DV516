package task_2;

public class DirectGraph extends Graph {

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
}
