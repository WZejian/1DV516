package task_3;

import java.io.File;

public class Node {
    private String data; // Data representing the file/folder name
    private Node child; // Reference to the leftmost child node
    private Node rightSibling;// Reference to the right sibling node


    public Node(String data) {
        this.data = data;
    }

    // Getter for retrieving the data (file/folder name)
    public String getData() {
        return data;
    }

    // Setter for updating the data (file/folder name)
    public void setData(String data) {
        this.data = data;
    }

    // Getter for retrieving the leftmost child node
    public Node getChild() {
        return child;
    }

    // Setter for setting the leftmost child node
    public void setChild(Node child) {
        this.child = child;
    }

    // Getter for retrieving the right sibling node
    public Node getRightSibling() {
        return rightSibling;
    }

    // Setter for setting the right sibling node
    public void setRightSibling(Node rightSibling) {
        this.rightSibling = rightSibling;
    }

    // Display the contents of this node and its children recursively
    public void displayContents() {
        System.out.println(this.getData());// Print the name of the file/folder represented by this node
        Node childNode = this.getChild();
        while (childNode != null) {
            childNode.displayContents(); // Recursively display the contents of child nodes
            childNode = childNode.getRightSibling(); //Move to the next sibling
        }
    }

}
