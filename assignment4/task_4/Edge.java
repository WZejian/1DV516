package task_4;

public class Edge {
    Vertex linked; // The vertex this edge points to.
    int weight;

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

    public Edge(Vertex linked) {
        this(linked, 1);
    }
}
