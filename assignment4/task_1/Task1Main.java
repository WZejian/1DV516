package task_1;

import java.util.Iterator;
import java.util.Scanner;

public class Task1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = null; // Declare the graph variable


        int answer=1;

        do {
            System.out.println("Select Graph Type:");
            System.out.println("1. Undirected Graph");
            System.out.println("2. Directed Graph");
            System.out.println("0. Exit Program");

            int graphTypeChoice = scanner.nextInt();

            switch (graphTypeChoice) {
                case 1:
                    graph = new UndirectedGraph(); // Create an undirected graph

                    break;
                case 2:
                    graph = new DirectGraph(); // Create a directed graph

                    break;
                case 0:
                    System.out.println("Exiting Program");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (graph == null);

        do {
            System.out.println("What operation do you want to perform?");
            System.out.println("Select Option number.");
            System.out.println("1. Add Vertex");
            System.out.println("2. Delete Vertex");
            System.out.println("3. Add Edge with weight");
            System.out.println("4. Update Edge with weight");
            System.out.println("5. Add Edge (Default Weight 1.0)");
            System.out.println("6. Delete Edge");
            System.out.println("7. Total number of edges in the graph");
            System.out.println("8. Total number of vertices (nodes) in the graph");
            System.out.println("9. Print Graph");
            System.out.println("10. Iterator by vertex");
            System.out.println("11. Iterator by edges");
            System.out.println("12. Iterator by the adjacency of a provided vertex");
            System.out.println("13. Degree of vertex ");

            try {

                answer = scanner.nextInt();

                switch (answer) {
                    case 1:
                        System.out.println("Add Vertex Operation -");
                        System.out.println("Enter State ID :");
                        int replyID = scanner.nextInt();
                        Vertex vertex = new Vertex(replyID);
                        graph.addVertex(vertex);
                        break;
                    case 2:
                        System.out.println("Delete Vertex Operation -");
                        System.out.println("Enter ID of Vertex(State) to Delete : ");
                        int replyDeleteVertex = scanner.nextInt();
                        graph.deleteVertexByID(replyDeleteVertex);
                        break;
                    case 3:
                        System.out.println("Add Edge Operation with weight");
                        System.out.println("Enter ID of Source Vertex(State): ");
                        int id1 = scanner.nextInt();
                        System.out.println("Enter ID of Destination Vertex(State): ");
                        int id2 = scanner.nextInt();
                        System.out.println("Enter Weight of Edge: ");
                        int w = scanner.nextInt();
                        graph.addEdgeByID(id1, id2, w);
                        break;
                    case 4:
                        System.out.println("Update Edge Operation with weight -");
                        System.out.println("Enter ID of Source Vertex(State): ");
                        int idSourceVertex = scanner.nextInt();
                        System.out.println("Enter ID of Destination Vertex(State): ");
                        int destinationVertex = scanner.nextInt();
                        System.out.println("Enter updated Weight of Edge: ");
                        int weightUpdate = scanner.nextInt();
                        graph.updateEdgeByID(idSourceVertex, destinationVertex, weightUpdate);
                        break;

                    case 5:
                        System.out.println("Add Edge Operation (Default Weight 1.0) -");
                        System.out.println("Enter ID of Source Vertex(State):");
                        int idDef1 = scanner.nextInt();
                        System.out.println("Enter ID of Destination Vertex(State):");
                        int idDef2 = scanner.nextInt();
                        graph.addEdgeByIDDef(idDef1, idDef2); // Default weight of 1.0
                        break;


                    case 6:
                        System.out.println("Delete Edge ");
                        System.out.println("Enter ID of Source Vertex(State): ");
                        int idSourceVertex2 = scanner.nextInt();
                        System.out.println("Enter ID of Destination Vertex(State): ");
                        int destinationVertex2 = scanner.nextInt();
                        graph.deleteEdgeByID(idSourceVertex2, destinationVertex2);
                        break;
                    case 7:
                        System.out.println("Total number of edges in the graph  " + graph.totalNumberofEdges());
                        break;
                    case 8:
                        System.out.println("Total number of vertices (nodes) in the grap  " + graph.totalNumberOfVerticies());
                        break;
                    case 9:
                        System.out.println("Print Graph Operation -");
                        graph.showGraph();
                        break;
                    case 10:
                        System.out.println("Iterator by vertex  ");
                        Iterator<Vertex> it = graph.iteratorByVertex();
                        while (it.hasNext()) {
                            Vertex v = it.next();
                            System.out.println(v.getStateID());

                        }
                        break;
                    case 11:
                        System.out.println("Iterator by edges  ");
                        Iterator<Edge> it2 = graph.iteratorEdge();
                        while (it2.hasNext()) {
                            Edge e = it2.next();
                            System.out.println(e.getDestinationVertexID());
                        }
                        break;
                    case 12:
                        System.out.println("Iterator by the adjacency of a provided vertex");
                        System.out.println("Enter Vertex ID: ");
                        int vertexID = scanner.nextInt();
                        //Vertex providedVertex = graph.getVertexByID(vertexID);
                        Iterator<Vertex> adjIterator = graph.iteratorAdjacencyVertex(vertexID);
                        while (adjIterator.hasNext()) {
                            Vertex v = adjIterator.next();
                            System.out.println(v.getStateID());
                        }
                        break;
                    case 13:
                        System.out.println("Degree of the vertex. Please enter ID of the vertex");
                        int replyVertex = scanner.nextInt();
                        if(graph instanceof UndirectedGraph g){
                        int degree= g.getDegree(replyVertex);
                        System.out.println(replyVertex + " is "+ degree);
                        }
                        else if (graph instanceof  DirectGraph g2){
                            int outDegree = g2.getOutDegree(replyVertex);
                            int inDegree = g2.getInDegree(replyVertex);
                            System.out.println(replyVertex + " has "+ "out degree" + outDegree);
                            System.out.println(replyVertex + " has "+ "in degree" + inDegree);
                        }
                        break;



                    default:
                        System.out.println("you write not correct number ");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        } while (answer!= 0);

    }
}




