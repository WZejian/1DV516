package task_5;


import java.util.ArrayList;
import java.util.List;

public class DirectGraph extends Graph {

    // Add an edge between two vertices in the directed graph
    @Override
    protected void addEdge(String fromVertex, String toVertex) {
        Vertex v1 = getVertexByID(fromVertex);
        Vertex v2 = getVertexByID(toVertex);
        boolean find = false;
        for (Vertex v:v1.getPrerequisites()){
            if(v.getStateID().equals(v2.getStateID())){
                find=true;
            }
        }
        if (find==false){
            v1.getPrerequisites().add(v2);
        }

    }

    // Create a copy of the directed graph
    public DirectGraph copyGraph() {
        DirectGraph graph = new DirectGraph();
        for (Vertex vertex : vertices) {
            Vertex v = graph.getVertexByID(vertex.getStateID());
            if(v == null){
                v=new Vertex(vertex.getStateID());
                graph.addVertex(v);
            }
            for(Vertex v2: vertex.getPrerequisites()){
                Vertex v3 = graph.getVertexByID(v2.getStateID());
                if(v3 == null){
                    v3=new Vertex(v2.getStateID());
                    graph.addVertex(v3);

                }
                v.getPrerequisites().add(v3);
            }

        }
        return graph;
    }

    // Find a vertex in the graph with no prerequisites
    public Vertex findVertexnoPrerequisite(){
        for ( Vertex vertex: vertices){
            if(vertex.getPrerequisites().size() == 0){
                return vertex;
            }
        }
        return null;
    }

    // Return a list of vertices in topological order
    public List<String> vertexList(){
        List<String> vertices = new ArrayList<>();
        DirectGraph copyGraph =copyGraph();
        while (copyGraph.vertices.size()>0){
            Vertex v = copyGraph.findVertexnoPrerequisite();
            if(v==null){
                break;
            }
            vertices.add(v.getStateID());
            copyGraph.deleteVertexByID(v.getStateID());
        }
        return vertices;
    }
}
