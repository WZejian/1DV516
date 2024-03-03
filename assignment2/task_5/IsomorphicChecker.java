package task_5;

public class IsomorphicChecker {
    public boolean isIsomorphic(Tree t1, Tree t2) {

        Node root1 = t1.root;
        Node root2 = t2.root;

        // Trees are isomorphic if they are empty.
        if (root1 == null && root2 == null) {
            return true;
        }

        // Trees are not isomorphic when one is empty but the other is not.
        if (root1 == null || root2 == null) {
            return false;
        }

        if(root1.value == root2.value) {

            // Subtrees rooted on the nodes.
            Tree t1_left = new Tree(root1.left);
            Tree t2_left = new Tree(root2.left);
            Tree t1_right = new Tree(root1.right);
            Tree t2_right = new Tree(root2.right);

            // Recursively checks left subtrees of both trees.
            boolean leftToLeftIsomorphic = isIsomorphic(t1_left, t2_left);

            // Recursively checks right subtrees of both trees.
            boolean rightToRightIsomorphic = isIsomorphic(t1_right, t2_right);

            // Recursively checks left subtrees to the right subtree
            boolean leftToRightIsomorphic = isIsomorphic(t1_left, t2_right);

            // Recursively checks left subtrees to the right subtree
            boolean rightToLeftIsomorphic = isIsomorphic(t1_right, t2_left);

            // Two trees are isomorphic if conditions below met.
            if ((leftToLeftIsomorphic && rightToRightIsomorphic) || (leftToRightIsomorphic && rightToLeftIsomorphic)) {
                return true;
            }
        }

        return false;
    }
}












