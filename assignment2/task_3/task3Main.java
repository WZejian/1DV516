package task_3;

import java.io.File;
import java.util.Scanner;

public class task3Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();

        while (true){
            System.out.println("1.enter directory ");
            System.out.println("2.find by name (enter the name with extension)");
            System.out.println("3.adding by name ");
            int reply = Integer.parseInt(scanner.nextLine());
            if (reply == 1){
                System.out.println("Enter the path of the subdirectory: ");
                String subDirPath = scanner.nextLine();
                File subDir = new File(subDirPath);
                tree.create(subDir); // Create a new subtree starting from the subdirectory
                System.out.println("Contents of the subdirectory:");
                tree.getRoot().displayContents();
            }
            else if (reply == 2){
                System.out.println("enter the name ");
                String nameFile = scanner.nextLine();
                Node p  = tree.find(nameFile);
                if ( p!=null){
                    System.out.println(" It is found it");
                    p.displayContents();
                }
                else{
                    System.out.println(" It is NOT found it");
                }
            }
            else if  (reply == 3){
                System.out.println("enter the name of the folder ");
                String folder = scanner.nextLine();
                System.out.println("enter the name of the file ");
                String fileName = scanner.nextLine();
                if(tree.add(folder, fileName)){
                    System.out.println("it has been added");

                }
            }

        }
    }
}
