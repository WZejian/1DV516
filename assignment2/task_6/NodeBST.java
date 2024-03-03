package task_6;

public class NodeBST {
    int Data;
    NodeBST leftChild;
    NodeBST rightChild;

    public NodeBST(int data, NodeBST leftChild, NodeBST rightChild) {
        this.Data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public NodeBST(int data) {
        this.Data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void displayNode() {
        System.out.println("Data: " + Data);
    }
}

