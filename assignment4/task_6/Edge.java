package task_6;

public class Edge {
    private int destinationVertexID;

    public Edge(int destVID) {
        destinationVertexID = destVID; // ID of the destination vertex

    }

    // Get the ID of the destination vertex
    public int getDestinationVertexID() {
        return destinationVertexID;
    }

};
