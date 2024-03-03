package task_5;

import java.util.ArrayList;

public class ThreeSumBruteforceMain {
      public static void main(String[] args) {
        ThreeSumBruteforce ts = new ThreeSumBruteforce();
        int [] b = {30, -40, -20, -10, 40, 0, 10, 5, 5, 10,-40};
        ArrayList <ArrayList<Integer>> listOfTriple=ts.threeSum(b);
        // Print the found triplets
        for (ArrayList<Integer> list: listOfTriple){
            System.out.println(list);
        }
    }
}
