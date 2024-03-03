package task_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * This binary search tree has functions such as add, delete, contains, get size,  get height
 * of the tree, delete the Kth largest value, iterators of inOrder, preOrder, postOrder and etc.
 * No duplicates in this tree.
 */
public class BinarySearchTree {
    Node root;

    /**
     * Gets the size of the tree, which is the amount of nodes.
     */
    public int getSize() {

        int count = 0;
        if (root == null) {
            return count;
        } else {
            Iterator<Node> iter = preOrderIterator();
            while (iter != null && iter.hasNext()) {
                iter.next();
                count++;
            }
        }
        return count;
    }


    /**
     * Gets the height(the deepest depth) of the tree.
     */
    public int getHeight() {
        if(root == null) {
            return 0;
        } else {
          return root.height();
        }

    }

    /**
     * Adds a value.
     */
    public void add(int val) {
        Node node = new Node(val);
        if(root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * Pre Order iteration.
     * @return Iterator
     */
    public Iterator<Node> preOrderIterator() {

        Iterator<Node> preOrder = new PreOrderIter();
        return preOrder;
    }

    private class PreOrderIter implements Iterator<Node> {
        Stack<Node> stck = new Stack<>();

        public PreOrderIter() {
            if (root != null) {
                stck.push(root);
            }
        }

        @Override
        public boolean hasNext() {

            boolean hasNext = !stck.isEmpty();
            return hasNext;
        }

        @Override
        public Node next() {
            Node n = stck.pop();
            if (n.right != null) {
                stck.push(n.right);
            }
            if (n.left != null) {
                stck.push(n.left);
            }
            return n;
        }
    }

    /**
     * In Order iteration.
     * @return Iterator
     */

    public Iterator<Node> inOrderIterator() {

        Iterator<Node> inOrder = new InOrderIter();
        return inOrder;
    }

    private class InOrderIter implements Iterator<Node> {
        Stack<Node> stck = new Stack<>();
        Node curr = root;

        @Override
        public boolean hasNext() {

            boolean hasNext = !stck.isEmpty() || curr != null;
            return hasNext;
        }

        @Override
        public Node next() {
            while (curr != null) {
                stck.push(curr);
                curr = curr.left;
            }
            curr = stck.pop();
            Node temp = curr;
            curr = curr.right;
            return temp;
        }
    }


    /**
     * Post Order iteration.
     * @return Iterator
     */

    public Iterator<Node> postOrderIterator() {

        Iterator<Node> postOrder = new PostOrderIter();
        return postOrder;
    }

    private class PostOrderIter implements Iterator<Node> {
        Stack<Node> stck1 = new Stack<>();
        Stack<Node> stck2 = new Stack<>();

        public PostOrderIter() {
            if (root != null) {
                stck1.push(root);
            }
            while (!stck1.isEmpty()) {
                Node n = stck1.pop();
                stck2.push(n);
                if (n.left != null) {
                    stck1.push(n.left);
                }
                if (n.right != null) {
                    stck1.push(n.right);
                }
            }
        }

        @Override
        public boolean hasNext() {

            boolean hasNext = !stck2.isEmpty();
            return hasNext;
        }

        @Override
        public Node next() {

            Node n = stck2.pop();
            return n;
        }
    }

    /**
     * Removes a value in the tree.
     */
    public void remove(int val) {

        root = remove(root, val);
    }

    /**
     * Removes a node which the attribute is a given value.
     */
    public Node remove(Node root, int val) {
        if(root == null) {
            return null;
        }

        if(val == root.val) {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.val = min(root.right);
            root.right = remove(root.right, root.val);
        } else if(val < root.val) {
            root.left = remove(root.left, val);
        } else {
            root.right = remove(root.right, val);
        }

        return root;
    }

    /**
     * Gets the minimum value.
     */
    private int min(Node root) {
        int minVal = root.val;
        while (root.left != null) {
            minVal = root.left.val;
            root = root.left;
        }
        return minVal;
    }


    /**
     * Checks if the tree contains a value.
     */
    public boolean contains(int val) {
        if(root == null) {
            return false;
        } else {
            return root.contains(val);
        }
    }

    /**
     * Remove the kth largest value in the tree.
     */
    public void removeKthLargest(int k) {
        if (k > getSize()){
            throw new RuntimeException("There is no kth largest value.");
        }
        List <Node> list = new ArrayList<>();
        Iterator <Node> it =inOrderIterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        remove(list.get(list.size()-k).val);
        //for (int i = list.size()-k;i<list.size();i++){
        //    remove(list.get(i).val);
        //}
    }

}
