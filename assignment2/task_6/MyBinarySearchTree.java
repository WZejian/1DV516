package task_6;


public class MyBinarySearchTree implements BaseTree {

    private  NodeBST root;

    // Check if the tree contains a specific data value
    public boolean contains(int data){
        return containsRecursive(data, root);
    }

    // Recursive method for checking data existence in the tree
    private boolean containsRecursive ( int data, NodeBST node ){
        if(node== null){
            return false;
        }
        else if (data > node.Data) {
            return containsRecursive(data, node.rightChild);
        }
        else if (data < node.Data) {
            return containsRecursive(data, node.leftChild);
        }
        else {
            return true;
        }
    }


    // Get the count (number of nodes) in the tree
    public int getCount(){
        return getCount(root);

    }

    // Recursive method for counting nodes in the tree
    private int getCount(NodeBST node){
        if(node ==null){
            return  0;
        }
        return getCount(node.leftChild)+getCount(node.rightChild)+1;
    }


    // Recursive method to search for a node in the binary search tree
    public NodeBST search(int key) {
        return searchRecursive(root, key);
    }

    // Recursive helper method for searching
    private NodeBST searchRecursive(NodeBST currentNode, int key) {
        if (currentNode == null) {
            return null; // Key not found
        }

        if (key == currentNode.Data) {
            return currentNode; // Key found in the current node
        } else if (key < currentNode.Data) {
            return searchRecursive(currentNode.leftChild, key); // Search in the left subtree
        } else {
            return searchRecursive(currentNode.rightChild, key); // Search in the right subtree
        }
    }

    // Method to insert a new node into the binary search tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive helper method for insertion
    private  NodeBST insertRecursive(NodeBST currentNode, int value) {
        if (currentNode == null) {
            return new NodeBST(value); // Create a new node when reaching a null leaf
        }

        if (value < currentNode.Data) {
            currentNode.leftChild = insertRecursive(currentNode.leftChild, value); // Recursively insert in the left subtree
        } else if (value > currentNode.Data) {
            currentNode.rightChild = insertRecursive(currentNode.rightChild, value); // Recursively insert in the right subtree
        }

        return currentNode; // Return the current node
    }

    // Method to delete a node from the binary search tree
    public boolean delete(int key) {
        // Initialize pointers
        NodeBST parent = null;
        NodeBST current = root;
        boolean isLeftChild = false;

        // Search for the node with the given key
        while (current != null && current.Data != key) {
            parent = current;
            if (key < current.Data) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
        }

        // Node with the given key not found
        if (current == null) {
            return false;
        }

        // Handle different cases for node deletion

        // Case 1: Node has no children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null; // The tree is now empty
            } else if (isLeftChild) {
                parent.leftChild = null; // Remove from parent
            } else {
                parent.rightChild = null; // Remove from parent
            }
        }
        // Case 2: Node has only a left child
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild; // Replace with left child
            } else {
                parent.rightChild = current.leftChild; // Replace with left child
            }
        }
        // Case 3: Node has only a right child
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild; // Replace with right child
            } else {
                parent.rightChild = current.rightChild; // Replace with right child
            }
        }
        // Case 4: Node has two children, replace with in-order successor
        else {
            NodeBST successor = getSuccessor(current);

            // Connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            // Connect successor to current's left child
            successor.leftChild = current.leftChild;
        }

        return true; // Node with the given key has been successfully deleted
    }

    // Helper method to find the in-order successor of a node
    private NodeBST getSuccessor(NodeBST nodeToReplace) {
        NodeBST successorParent = null;
        NodeBST successor = nodeToReplace.rightChild;

        // Find the leftmost child of the right subtree
        while (successor.leftChild != null) {
            successorParent = successor;
            successor = successor.leftChild;
        }

        // If the successor is not the right child of the node to replace,
        // make the necessary adjustments
        if (successorParent != null) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToReplace.rightChild;
        }

        return successor;
    }

    // Method to display the binary search tree
    public void displayTree() {
        displayTreeRecursive(root);
    }

    // Recursive helper method for displaying the tree in-order
    private void displayTreeRecursive(NodeBST currentNode) {
        if (currentNode != null) {
            displayTreeRecursive(currentNode.leftChild);
            currentNode.displayNode();
            displayTreeRecursive(currentNode.rightChild);
        }
    }

    private int getHeight(NodeBST node) {
       if (node ==null){
           return 0;
       }
       int l = getHeight(node.leftChild);
       int r = getHeight(node.rightChild);
       if (l>r){
           return l+1;
       }else{
           return r+1;
       }
    }

    public int getHeight() {
       return getHeight(root);
    }



    // Public method to initiate a preorder traversal of the binary search tree
    public void preorderTraversal() {
        preorder(root);
    }

    // Recursive method to perform a preorder traversal of the binary search tree
    private void preorder(NodeBST currentNode) {
        if (currentNode != null) {
            // Process the current node (e.g., display or perform an operation)
            currentNode.displayNode();

            // Recursively traverse the left subtree
            preorder(currentNode.leftChild);

            // Recursively traverse the right subtree
            preorder(currentNode.rightChild);
        }
    }

}
