package task_3;

import java.util.Objects;

class Edge {
    private int destinationVertexID;
    private double weight;
    private int source;

    public Edge(int destVID,int s, double w) {
        destinationVertexID = destVID; // ID of the destination vertex
        weight = w;
        source = s;// Weight of the edge
    }

    public int getSource() {
        return source;
    }

    // Set the weight of the edge to the provided value
    public void setWeight(double w) {
        weight = w;
    }

    // Get the ID of the destination vertex
    public int getDestinationVertexID() {
        return destinationVertexID;
    }

    // Get the weight of the edge
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return destinationVertexID == edge.destinationVertexID && Double.compare(edge.weight, weight) == 0 && source == edge.source ||
                destinationVertexID == edge.source && Double.compare(edge.weight, weight) == 0 && source == edge.destinationVertexID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
