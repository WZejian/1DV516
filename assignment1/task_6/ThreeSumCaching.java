package task_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Three numbers sum up to a constant, here the constant is 0 we choose.
 */
public class ThreeSumCaching {

    // Method to find all triplets in the array
    public static ArrayList <ArrayList<Integer>> threeSum(int[] list) {

        ArrayList <ArrayList<Integer>> listOfTriple= new ArrayList<>();
        HashSet <Integer> set = new HashSet<>();            
        //Avoid duplicates in the input list. 
        HashSet <Integer> setArray = new HashSet<>(Arrays.stream(list).boxed().toList());

        list=new int[setArray.size()];
        int k = 0;
        for (Integer p:setArray){
            list [k]=p;
            k++;
        }


        for (int i = 0; i < list.length; i++) { //Loop over array elements (N)
            set.add(list[i]);// Add the current element to the HashSet
            for (int j = i + 1; j < list.length; j++) { //Nested loop for combinations (N^2)
                int p = list[i] + list[j]; // Calculate the pair sum
                // Check if the negation of the pair sum exists in the HashSet
                if (-p!=list[i] && -p!=list[j] && set.contains(-p)){

                    // Found a triplet, add it to the result list
                    ArrayList <Integer> triple = new ArrayList<>(List.of(list[i],list[j],-p));
                    listOfTriple.add(triple);
                }
            }
        }
        return listOfTriple; // Return the list of triplets
    }


}