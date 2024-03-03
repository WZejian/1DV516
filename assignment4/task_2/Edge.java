package task_2;

public class Edge {
    private int destinationVertexID;
    private double weight;

    public Edge(int destVID, double w) {
        destinationVertexID = destVID; // ID of the destination vertex
        weight = w; // Weight of the edge
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
}
