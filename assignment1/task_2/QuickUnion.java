package task_2;

import java.util.ArrayList;

/*
* Here we use the quick union, union two elements means set one element as the father of the other one.
* */
public class QuickUnion {

    // Stores the father of each element(index of the list).
    private ArrayList<Integer> father;

    // Initially the father of each element is itself.
    public QuickUnion(int n) {

        father = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            father.add(i);
        }
    }

    // Find the root element by continually finding its father.
    public int find(int m) {

        boolean found = false;
        int root = 0;

        // Continuously update 'a' until it matches its father's value.
        while (!found) {
            if (m == father.get(m)) {
                root = m;
                found = true;
            } else {
                m = father.get(m);
            }

        }
        return root;
    }

    // Check if two elements 'a' and 'b' are connected or not.
    public boolean connected(int m, int n) {

        boolean isConnected = true;

        int rm = find(m);
        int rn = find(n);

        if (rm != rn) {
            isConnected = false;
        }

        return isConnected;
    }

    // Union two elements 'a' and 'b' by setting the root of 'a' to the root of 'b'
    public void union(int m, int n) {
        
        int rm = find(m);
        int rn = find(n);

        if (rm == rn) {
            // System.out.println(a + " and " + b + " has already been connected");
            return;
        }
        father.set(rm, rn);

    }

    @Override
    public String toString() {
        return "root:  " + father.toString();
    }

}
