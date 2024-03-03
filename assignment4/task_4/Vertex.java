package task_4;

import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited;
    int dist = INF;
    Vertex prev = null;
    static final Integer INF = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " dist:" + this.dist;
    }
}
