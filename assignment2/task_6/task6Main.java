package task_6;

import java.util.Random;

public class task6Main {


    static void implementationOfWork(BaseTree tree){
        Random random = new Random();
        Long start = System.currentTimeMillis();


        // Insert random values into the tree
        for (int i = 0; i < 1000000; i++) {
            int k = random.nextInt(0, 1000000);
            tree.insert(k);

            }
        System.out.println("After inserting - Number of nodes in the tree    " + tree.getCount());
        System.out.println("After inserting- Height of the tree              " + tree.getHeight());

        // Delete random values from the tree
        for ( int i = 0; i<1000000; i++){
            int k= random.nextInt(0, 1000000);
            tree.delete(k);

        }

        System.out.println("After deleting - Number of nodes in the tree    " + tree.getCount());
        System.out.println("After deleting -  Height of the tree            " + tree.getHeight());

        Long finish  = System.currentTimeMillis();
        Long endTime=finish-start;
        System.out.println("Time which took for insert and delete operation is " + endTime + " " + "milliseconds");



        Long startSearch = System.currentTimeMillis();
        // Search random values
        for ( int i = 0; i<1000000; i++){
            int k= random.nextInt(0, 1000000);
            tree.contains(k);

        }

        Long finishSearch  = System.currentTimeMillis();
        Long endTimeSearch=finishSearch-startSearch;
        System.out.println("Time which took for search operation is " + endTimeSearch + " " + "milliseconds");

    }


    public static void main(String[] args) {
        int numberOfRuns = 10;
        for (int run = 1; run <= numberOfRuns; run++) {
            AVLTree AVLTree = new AVLTree();
            MyBinarySearchTree BSTtree = new MyBinarySearchTree();
            System.out.println(" ");
            System.out.println("Run " + run + ":");
            System.out.println("AVL Tree:");
            implementationOfWork(AVLTree);
            System.out.println("\nBST Tree:");
            implementationOfWork(BSTtree);
        }
    }
}
