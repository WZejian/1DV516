package task_3;

import java.io.File;

public class Tree {
    private Node root; // store the root of the tree.

    // Getter method to retrieve the root node of the tree.
    public Node getRoot() {
        return root;
    }

    // Setter method to set the root node of the tree.
    public void setRoot(Node root) {
        this.root = root;
    }

    //create a tree structure to represent the contents of a file system directory.
    public void create(File file ){
        root=recursiveCreate(file);
    }

    // recursively create a tree structure from a file system directory
    private Node recursiveCreate(File file){
        Node node = new Node(file.getName());//  Create a node for the current file/folder
        File [] files = file.listFiles();// It obtains an array of File objects representing the contents of the current directory (including both files and subfolders).
        Node p = null; // It will be used to keep track of the right sibling when adding nodes to the tree.
        //The for loop iterates through each file or folder within the current directory.
        for (int i=0; i< files.length; i++){
            Node node1;
            if (files[i].isDirectory()){
                node1=recursiveCreate(files[i]);
            }
            else{
                node1=new Node(files[i].getName());
            }

            if (i ==0){
                node.setChild(node1);
            }
            else {
                p.setRightSibling(node1);

            }

            p= node1;
        }
        return node;
    }

    //  Find a node with a specific data (file/folder name) within the tree.
    public Node find (String data){
        return recursiveFind(data,root);
    }

    // Add a file node to a folder node in the tree.
    public boolean add( String folder, String file){
        Node p = find(folder);
        if ( p!= null){
            Node t = new Node(file);
            if (p.getChild()==null){
                p.setChild(t);
            }
            else {
                Node child = p.getChild();
                while (child.getRightSibling()!=null){
                    child = child.getRightSibling();
                }
                child.setRightSibling(t);
            }
            return true;
        }
        return false;
    }

    // Recursively find a node with specific data (file/folder name) within the tree.
    private Node recursiveFind(String data, Node p){
        while (p!= null){
            if (p.getData().equals(data)){
                return p;
            }
            Node t = recursiveFind(data, p.getChild());
            if (t!= null){
                return t;
            }
            p=p.getRightSibling();
        }
        return null;
    }
}
