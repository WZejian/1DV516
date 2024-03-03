package task_5;

public class task5Main {
    public static void main(String[] args) {
        //Binary tree1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.right = new Node(7);
        root1.left.right.left = new Node(6);
        root1.right.right.left = new Node(8);
        Tree tree1 = new Tree(root1);

        //Binary tree2
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(5);
        root2.right.right = new Node(4);
        root2.right.left.left = new Node(6);
        root2.left.left = new Node(7);
        root2.left.left.right = new Node(8);

        Tree tree2 = new Tree(root2);

        IsomorphicChecker checker = new IsomorphicChecker();
        System.out.println("Two trees are isomorphic? " + checker.isIsomorphic(tree1, tree2));
    }
}
