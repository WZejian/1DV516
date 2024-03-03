package task_2;

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

}
