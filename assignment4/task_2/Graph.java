package task_2;


import java.util.*;

public abstract class Graph {
    // List to store vertices in the graph
    protected LinkedList<Vertex> vertices = new LinkedList<>(); // List to store vertices in the graph

    // Check if a vertex with the given ID exists in the graph
    public boolean checkIfVertexExistByID(int vid) {
        boolean flag = false;
        for (Vertex vertex: vertices) {
            if (vertex.getStateID()== vid) {
                return true;
            }
        }
        return false;
    }


    // Add a new vertex to the graph
    public  void addVertex(Vertex newVertex) {
        boolean check = checkIfVertexExistByID(newVertex.getStateID());
        if (check == true) {
             System.out.println("Vertex with this ID already exist"); ;
        } else {
            vertices.add(newVertex);
        }
    }
    // Get a vertex in the graph by its ID
    Vertex getVertexByID(int vid) {
        for (Vertex vertex: vertices) {
            if (vertex.getStateID() == vid) {
                return vertex;
            }
        }
        return null;
    }


    // Check if an edge with a specific source and destination vertex ID exists in the graph
    public boolean checkIfEdgeExistByID(int fromVertex, int toVertex) {
        Vertex v = getVertexByID(fromVertex);
        LinkedList <Edge> e = v.getEdgeList();
        for (Edge edge: e) {
            if (edge.getDestinationVertexID() == toVertex) {
                return true;
            }
        }
        return false;
    }


    // add edge
    protected abstract void addEdge (int fromVertex, int toVertex, double weight);


    public void addEdgeByID(int fromVertex, int toVertex, double weight) {
        boolean check1 = checkIfVertexExistByID(fromVertex);
        boolean check2 = checkIfVertexExistByID(toVertex);
        boolean check3 = checkIfEdgeExistByID(fromVertex, toVertex);

        if ((check1 && check2 == true)) {
            if (check3 == true) {
                throw new RuntimeException("this edge already exists");

            } else {
                addEdge(fromVertex, toVertex, weight);

             }
        } else {
             throw  new RuntimeException("Invalid Vertex ID entered");
       }
     }


    // Display graph
    public void showGraph(){
        for (Vertex vertex: vertices){
            System.out.print(vertex.getStateID()+ " --- ");
            for (Edge edge: vertex.getEdgeList()){
                System.out.print(edge.getDestinationVertexID()+ " (" + edge.getWeight() + "), ");

            }
            System.out.println( );
        }
    }

    // Check if a path exists between two vertices using Depth-First Search
    public boolean isPathExistsDFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        if(getVertexByID(sourceVertex )== null || getVertexByID(targetVertex )== null){
            throw new RuntimeException("Path does not exist between these vertex");
        }
        return isPathExistsDFS(sourceVertex, targetVertex, visited);
    }

    private boolean isPathExistsDFS(int currentVertex, int targetVertex, Set<Integer> visited) {
        if (visited.contains(currentVertex)) {
            return false;
        }
        visited.add(currentVertex);

        if (currentVertex == targetVertex) {
            return true;
        }

        for (Edge edge : getVertexByID(currentVertex).getEdgeList()) {
            if (!visited.contains(edge.getDestinationVertexID())) {
                if (isPathExistsDFS(edge.getDestinationVertexID(), targetVertex, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Find a path between two vertices using Depth-First Search
    public List<Integer> findPathDFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(sourceVertex);
        visited.add(sourceVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();

            if (currentVertex == targetVertex) {
                path.addAll(stack);
                return path;
            }

            boolean hasUnvisitedNeighbor = false;

            for (Edge edge : getVertexByID(currentVertex).getEdgeList()) {
                int neighbor = edge.getDestinationVertexID();
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                    hasUnvisitedNeighbor = true;
                    break;
                }
            }

            if (!hasUnvisitedNeighbor) {
                stack.pop();
            }
        }

        return path;
    }

    // Check if a path exists between two vertices using Breadth-First Search
    public boolean isPathExistsBFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        if(getVertexByID(sourceVertex )== null || getVertexByID(targetVertex )== null){
            throw new RuntimeException("Path does not exist between these vertex");
        }
        return isPathExistsBFS(sourceVertex, targetVertex, visited);
    }

    // BFS function to check if a path exists between two vertices
    private boolean isPathExistsBFS(int sourceVertex, int targetVertex, Set<Integer> visited) {
        if (sourceVertex == targetVertex) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited.add(sourceVertex);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (Edge edge : getVertexByID(currentVertex).getEdgeList()) {
                int neighborVertex = edge.getDestinationVertexID();
                if (!visited.contains(neighborVertex)) {
                    if (neighborVertex == targetVertex) {
                        return true;
                    }
                    visited.add(neighborVertex);
                    queue.add(neighborVertex);
                }
            }
        }

        return false;
    }

    // Find a path between two vertices using Breadth-First Search
    public List<Integer> findPathBFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        List<Integer> path = new ArrayList<>();

        if (findPathBFS(sourceVertex, targetVertex, visited, parentMap)) {
            int currentVertex = targetVertex;
            while (currentVertex != sourceVertex) {
                path.add(currentVertex);
                currentVertex = parentMap.get(currentVertex);
            }
            path.add(sourceVertex);
            Collections.reverse(path);
        }

        return path;
    }

    // BFS function to find a path between two vertices
    private boolean findPathBFS(int sourceVertex, int targetVertex, Set<Integer> visited, Map<Integer, Integer> parentMap) {
        if (sourceVertex == targetVertex) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited.add(sourceVertex);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (Edge edge : getVertexByID(currentVertex).getEdgeList()) {
                int neighborVertex = edge.getDestinationVertexID();
                if (!visited.contains(neighborVertex)) {
                    visited.add(neighborVertex);
                    parentMap.put(neighborVertex, currentVertex);
                    queue.add(neighborVertex);
                    if (neighborVertex == targetVertex) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
