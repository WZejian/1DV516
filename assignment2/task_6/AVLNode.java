package task_6;

public class AVLNode {
    public int key;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }


}