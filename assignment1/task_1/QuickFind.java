package task_1;

import java.util.ArrayList;

/*
* This class has functions finding an element by its id;
* Unioning two elements by their id and Checking if two elements
* are under the same id to show if they are connected or not.
* */
public class QuickFind {

    // Stores the id of each element
    private ArrayList<Integer> id  = new ArrayList<>();

    public QuickFind(int n) {

        for( int i=0; i<n; i++){
            id.add(i);
        }
    }

    // Checks if two elements 'a' and 'b' are connected or not
    public boolean connected (int a, int b){

        return find(a) == find(b);

    }

    // Gets the id of a through its value by index a.
    public int find(int a){

        return id.get(a);
    }


    // Union two elements 'a' and 'b' by setting both the same id.
    public void union (int a, int b){
        if (connected(a, b)) {
            //System.out.println(a + " and " + b + " has already been connected");
            return;
        }

        int id_a = find(a); 
        int id_b = find(b); 
        for(int i = 0; i < id.size(); i++) {
          if(id.get(i) == id_a) {
            id.set(i, id_b);
          }
        }
    }

    @Override
    public String toString() {
        return id.toString();
    }


}

