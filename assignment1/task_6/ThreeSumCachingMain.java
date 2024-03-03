package task_6;

import java.util.ArrayList;

public class ThreeSumCachingMain {
      public static void main(String[] args) {
        // int [] b = {30, -40, -20, -10, 40, 0, 10, 5};
        int [] b = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5,5};
        ThreeSumCaching ts = new ThreeSumCaching();

        ArrayList <ArrayList<Integer>> listOfTriple=ts.threeSum(b);
        // Print the found triplets
        for (ArrayList<Integer> list: listOfTriple){
            System.out.println(list);
        }
    }
}
