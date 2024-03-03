package task_6;

public class AVLTree implements BaseTree {

    private AVLNode root;




    // Check if the tree contains a specific data value
    public boolean contains(int data){
        return containsRecursive(data, root);
    }

    private boolean containsRecursive ( int data, AVLNode node ){
        if(node== null){
            return false;
        }
        else if (data > node.key) {
            return containsRecursive(data, node.right);
        }
        else if (data < node.key) {
            return containsRecursive(data, node.left);
        }
        else {
            return true;
        }
    }


    // Get the total number of nodes in the tree
    public int getCount(){
        return getCount(root);

    }

    private int getCount(AVLNode node){
        if(node ==null){
            return  0;
        }
        return getCount(node.left)+getCount(node.right)+1;
    }


    // Constructor to initialize an empty AVL tree
    public AVLTree() {
        this.root = null;

    }

    // Recursive method to insert a node into the AVL tree
    private AVLNode insertNodeRecursive(AVLNode node, int key) {
        if (node == null) {
            // If the node is null, create a new node with the given key
            return new AVLNode(key);
        }

        if (node.key > key) {
            // If the key is smaller than the current node's key, recursively insert it in the left subtree
            node.left = insertNodeRecursive(node.left, key);
        } else if (node.key < key) {
            // If the key is greater than the current node's key, recursively insert it in the right subtree
            node.right = insertNodeRecursive(node.right, key);
        }

        // Balance the tree after insertion
        return balance(node);
    }

    // Public method to insert a node into the AVL tree
    public void insert(int key) {
        this.root = insertNodeRecursive(this.root, key);

    }

    // Recursive method to balance the AVL tree
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return node;
        }
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            // Left subtree is unbalanced
            if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                // Single rotation
                node = rotateLeft(node);
            } else {
                // Double rotation
                node = doubleLeft(node);
            }
        } else if (getHeight(node.right) - getHeight(node.left) > 1) {
            // Right subtree is unbalanced
            if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                // Single  rotation
                node = rotateRight(node);
            } else {
                // Double  rotation
                node = doubleRight(node);
            }
        }

        // Update the height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }


    //  getting the height of a node
    private int getHeight(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int getHeight() {
        return root.height;
    }

    // Recursive method to perform a single left rotation
    private AVLNode rotateLeft(AVLNode r2) {
        AVLNode r1 = r2.left;
        r2.left = r1.right;
        r1.right = r2;

        // Update the heights of the rotated nodes
        r2.height = Math.max(getHeight(r2.left), getHeight(r2.right)) + 1;
        r1.height = Math.max(getHeight(r1.left), r2.height) + 1;

        return r1;
    }


    // Recursive method to perform a single right rotation
    private AVLNode rotateRight(AVLNode r2) {
        AVLNode r1 = r2.right;
        r2.right = r1.left;
        r1.left = r2;

        // Update the heights of the rotated nodes
        r2.height = Math.max(getHeight(r2.left), getHeight(r2.right)) + 1;
        r1.height = Math.max(getHeight(r1.left), r2.height) + 1;

        return r1;
    }

    // Recursive method to perform a double right rotation (RL or double right):
    private AVLNode doubleRight(AVLNode node) {
        // single left rotation on the right child.
        node.right = rotateLeft(node.right);
        // single right rotation on the given node.
        return rotateRight(node);
    }


    // Recursive method to perform a double left rotation
    private AVLNode doubleLeft(AVLNode node) {
        //single right rotation on the left child.
        node.left = rotateRight(node.left);
        //single left rotation on the given node.
        return rotateLeft(node);
    }


    // Recursive method to delete a node from the AVL tree
    private AVLNode deleteNode(AVLNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key > key) {
            node.left = deleteNode(node.left, key);
        } else if (node.key < key) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            // Replace the current node with the minimum value in the right subtree
            node.key = findMin(node.right);
            node.right = deleteNode(node.right, node.key);
        }

        // Balance the tree after deletion
        return balance(node);
    }

    // Public method to delete a node from the AVL tree
    public boolean delete(int key) {
        this.root = deleteNode(this.root, key);
        return true;
    }

    //  find the minimum value in a subtree
    private int findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    // Initiate a preorder traversal of the AVL tree
    public void printPreorder() {
        preorder(root);
    }

    // Recursive method to perform a preorder traversal of the AVL tree
    private void preorder(AVLNode node) {
        if (node != null) {
            // Print the key value of the current node
            System.out.println(node.key);

            // Recursively traverse the left subtree
            preorder(node.left);

            // Recursively traverse the right subtree
            preorder(node.right);
        }
    }
}
