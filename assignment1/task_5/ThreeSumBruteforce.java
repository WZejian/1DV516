package task_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Three numbers sum up to a constant, here the constant is 0 we choose.
 */
public class ThreeSumBruteforce {
    // Method to find all triplets in the array that sum up to zero
    public static ArrayList <ArrayList<Integer>> threeSum(int[] list) {
        ArrayList <ArrayList<Integer>> listOfTriple= new ArrayList<>();
        //Avoid duplicates in the input list.
        HashSet<Integer> setArray = new HashSet<>(Arrays.stream(list).boxed().toList());
        list=new int[setArray.size()];
        int s = 0;
        for (Integer p:setArray){
            list [s]=p;
            s++;
        }

        for (int i = 0; i < list.length; i++) { //Loop over array elements (N elements)
            for (int j = i + 1; j < list.length; j++) { //Nested loop for combinations (N^2)
                for (int k = j + 1; k < list.length; k++) { //Nested loop for combinations (N^3)
                    if (list[i] + list[j] + list[k] == 0 && list[i]!=list[j] && list[i]!=list[k]&& list[j]!=list[k]) { //Check if the sum of three elements is zero
                        ArrayList <Integer> triple = new ArrayList<>(List.of(list[i],list[j],list[k] ));
                        listOfTriple.add(triple); //Add the triplet to the result lis
                    }
                }
            }
        }
        return listOfTriple; //Return the list of triplets
    }

}
