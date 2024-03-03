package task_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UndirectedGraph extends Graph {


    private void addLinkedVertex(HashSet <Vertex> linkedVertex, Vertex v){
        if (linkedVertex.contains(v) || v==null){
            return;
        }
        linkedVertex.add(v);
        for( Edge edge: v.getEdgeList()){
            Vertex p=getVertexByID(edge.getDestinationVertexID());
            addLinkedVertex(linkedVertex,p);
        }
    }

    public List<MST> buildOfTrees( ){
        HashSet <Vertex> allVertices = new HashSet<>(vertices);
        ArrayList <MST> listMst = new ArrayList<>();
        while(allVertices.size()>0){
            Vertex v = null;
            for (Vertex p: vertices){
                if(allVertices.contains(p)){
                    v=p;
                    break;
                }
            }
            HashSet <Vertex> linkedVertex = new HashSet<>();
            addLinkedVertex(linkedVertex, v);
            allVertices.removeAll(linkedVertex);
            ArrayList <Edge>edges = new ArrayList<>();
            for (Vertex t:linkedVertex){
                edges.addAll(t.getEdgeList());
            }
            //List<Edge> e = new ArrayList<>(edges);

            MST mst = MST.findMinimumSpanningTree(vertices.size()+1, edges);
            listMst.add(mst);

        }
        return listMst;

    }

    // add edge
    @Override
    protected void addEdge(int fromVertex, int toVertex, double weight) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == fromVertex) {
                Edge e = new Edge(toVertex,fromVertex, weight);

                vertex.getEdgeList().add(e);

            } else if (vertex.getStateID() == toVertex) {
                Edge e = new Edge(fromVertex, toVertex,weight);
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
