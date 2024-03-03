package task_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }


    /**
     * Insert a new node to the tree.
     */
    public void add(Node node) {

        if(node.val < this.val) {
            if(this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
                return;
            }
        }
        if(node.val > this.val) {
            if(this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
                return;
            }
        }
        if(node.val == this.val) {
            System.out.println("Cannot add the value, already have the same value in the tree!");
            return;
        }
    }

    /**
     * Check if the tree contains a node with specific value.
     * @param val  value
     * @return true or false
     */
    public boolean contains(int val) {

        if(val == this.val) {
            return true;
        } else if(val < this.val) {
            if(this.left != null) {
                return this.left.contains(val);
            }
        } else {
            if(this.right != null) {
                return this.right.contains(val);
            }
        }

        return false;
    }

    /**
     * PreOrder iteration.
     */
    public Iterator<Node> preOrderIterator() {
        ArrayList<Node> lst = new ArrayList<>();
        preOrder(lst);
        return lst.iterator();
    }
    public void preOrder(ArrayList<Node> lst) {

        lst.add(this);
        if(this.left != null) {
            this.left.preOrder(lst);
        }
        if(this.right != null) {
            this.right.preOrder(lst);
        }
    }

    /**
     * Inorder iteration.
     */
    public Iterator<Node> inOrderIterator() {
        ArrayList<Node> lst = new ArrayList<>();
        inOrder(lst);
        return lst.iterator();
    }
    public void inOrder(ArrayList<Node> lst) {
        if(this.left != null) {
            this.left.inOrder(lst);
        }
        lst.add(this);
        if(this.right != null) {
            this.right.inOrder(lst);
        }
    }

    /**
     * PostOrder iteration.
     */
    public Iterator<Node> postOrderIterator() {
        ArrayList<Node> lst = new ArrayList<>();
        postOrder(lst);
        return lst.iterator();
    }

    public void postOrder(ArrayList<Node> lst) {

        if(this.left != null) {
            this.left.postOrder(lst);
        }
        if(this.right != null) {
            this.right.postOrder(lst);
        }
        lst.add(this);
    }

    /**
     * Calculate the height of tree, which is the maximum depth.
     */
    public int height() {

        int leftHgt = 0, rightHgt = 0;

        if (this.left != null) {
            leftHgt = this.left.height();
        }

        if (this.right != null) {
            rightHgt = this.right.height();
        }

        int maxHgt = leftHgt > rightHgt ? leftHgt : rightHgt;

        return maxHgt + 1;

    }

    @Override
    public String toString() {
        return "Node (value=" + val + ")";
    }

}
