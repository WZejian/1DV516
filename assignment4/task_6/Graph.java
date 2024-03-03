package task_6;

import java.util.*;

public abstract class Graph {
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
             System.out.println("Vertex with this ID already exist");
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

    // add an edge
    protected abstract void addEdge (int fromVertex, int toVertex);

    public void addEdgeByID(int fromVertex, int toVertex) {
        boolean check1 = checkIfVertexExistByID(fromVertex);
        boolean check2 = checkIfVertexExistByID(toVertex);
        boolean check3 = checkIfEdgeExistByID(fromVertex, toVertex);

        if ((check1 && check2 == true)) {
            if (check3 == true) {
                throw new RuntimeException("this edge already exists");

            } else {
                addEdge(fromVertex, toVertex);

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
                System.out.print(edge.getDestinationVertexID());

            }
            System.out.println( );
        }
    }

    // Check if a path exists between two vertices using Depth-First Search (DFS)
    public boolean isPathExistsDFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        if(getVertexByID(sourceVertex )== null || getVertexByID(targetVertex )== null){
            throw new RuntimeException("Path does not exist between these vertex");
        }
        return isPathExistsDFS(sourceVertex, targetVertex, visited);
    }

    // function to implement DFS
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

    // Find a path between two vertices using Depth-First Search (DFS)
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

    // Check if a path exists between two vertices using Breadth-First Search (BFS)
    public boolean isPathExistsBFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        if(getVertexByID(sourceVertex )== null || getVertexByID(targetVertex )== null){
            throw new RuntimeException("Path does not exist between these vertex");
        }
        return isPathExistsBFS(sourceVertex, targetVertex, visited);
    }

    // function to implement BFS
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

    protected abstract void deleteEdge (int fromVertex, int toVertex);

    // Delete an edge between two vertices
    public void deleteEdgeByID(int fromVertex, int toVertex) {
        boolean check = checkIfEdgeExistByID(fromVertex, toVertex);
        if (check == true) {
            deleteEdge(fromVertex, toVertex);
        }


    }

    // Find a path between two vertices using Breadth-First Search (BFS)
    public List<Integer> findPathBFS(int sourceVertex, int targetVertex) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        List<Integer> path = new ArrayList<>();

        // If a path exists, backtrack from the target vertex to the source vertex and create the path
        if (findPathBFS(sourceVertex, targetVertex, visited, parentMap)) {
            int currentVertex = targetVertex;
            while (currentVertex != sourceVertex) {
                path.add(currentVertex);
                currentVertex = parentMap.get(currentVertex);
            }
            path.add(sourceVertex);
            Collections.reverse(path);// Reverse the path to have it from source to target
        }

        return path;
    }

    // function to implement BFS and find the path
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
