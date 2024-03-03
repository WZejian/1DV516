package task_3;

public class Union {

    // Union operation to merge two subsets based on their heights (ranks).
    static void union(MST.DisjointSet[] subsets, int a, int b) {
        int rootA = findRoot(subsets, a);
        int rootB = findRoot(subsets, b);

        if (subsets[rootB].height < subsets[rootA].height) {
            subsets[rootB].parent = rootA;
        } else if (subsets[rootA].height < subsets[rootB].height) {
            subsets[rootA].parent = rootB;
        } else {
            subsets[rootB].parent = rootA;
            subsets[rootA].height++;
        }
    }

    //Find the root of the subset to which an element belongs.
    static int findRoot(MST.DisjointSet[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
}
