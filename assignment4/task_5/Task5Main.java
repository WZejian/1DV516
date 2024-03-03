package task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Task5Main {
    public static void main(String[] args) throws IOException {
        DirectGraph graph = new DirectGraph();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] courseData = line.split(";");
            String courseName = courseData[0].trim();
            String prerequisiteName = courseData[1].trim();
            if(!graph.checkIfVertexExistByID(courseName)){
                Vertex v1 = new Vertex(courseName);
                graph.addVertex(v1);
            }
            if(!graph.checkIfVertexExistByID(prerequisiteName)){
                Vertex v2 = new Vertex(prerequisiteName);
                graph.addVertex(v2);
            }
            graph.addEdgeByID(courseName,prerequisiteName);
        }
        br.close();
        System.out.println("Before sorting: ");
        graph.show();
        List<String> result = graph.vertexList();
        System.out.println();
        System.out.println("The following result after sorting: ");
        for (int i=0; i< result.size(); i++){
            System.out.println(result.get(i));
        }

    }

}




