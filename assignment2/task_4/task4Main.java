package task_4;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Tree built with 7 nodes initially.
 */
public class task4Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(4);
        bst.add(2);
        bst.add(5);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(0);
        BinarySearchTree binarySortTree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            // Display menu options
            System.out.println("1. Add a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Remove the Kth largest value");
            System.out.println("4. Show height of the tree");
            System.out.println("5. Get the size");
            System.out.println("6. Enter a value to show if the tree contains");
            System.out.println("7. Print in inorder ");
            System.out.println("8. Print in preorder ");
            System.out.println("9. Print in post-order ");
            System.out.println("10. Quit");

            // Read the user's choice
            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Enter a number to add ");
                    int reply1 = scanner.nextInt();
                    bst.add(reply1);
                    break;
                case 2:
                    System.out.println("Enter the number to delete  ");
                    int reply2 = scanner.nextInt();
                    bst.remove(reply2);
                    break;
                case 3:
                    System.out.println("Removing the Kth largest value. Please enter the k  ");
                    int reply3 = scanner.nextInt();
                    try {
                        bst.removeKthLargest(reply3);
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(" The height  is " + bst.getHeight());
                    break;

                case 5:
                    System.out.println(" The size is " + bst.getSize());
                    break;

                case 6:
                    System.out.println(" please enter the element to see it exists in the tree or not");
                    int reply4 = scanner.nextInt();
                    if (bst.contains(reply4)) {
                        System.out.println(" The tree contains this element");
                    } else {
                        System.out.println(" The tree DOES NOT contain this element");
                    }

                    break;

                case 7:
                    Iterator<Node> p = bst.inOrderIterator();
                    while (p.hasNext()) {

                        System.out.println(p.next());
                    }

                    break;

                case 8:
                    Iterator<Node> p2 = bst.preOrderIterator();
                    while (p2.hasNext()) {

                        System.out.println(p2.next());
                    }
                    break;
                case 9:
                    Iterator<Node> p3 = bst.postOrderIterator();
                    while (p3.hasNext()) {
                        System.out.println(p3.next());

                    }
                    break;
                case 10:
                    flag = false;
            }
        }
    }
}

