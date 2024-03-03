package task_7;

import task_3.MethodTimer;
import task_5.ThreeSumBruteforce;
import java.util.Random;
import task_6.ThreeSumCaching;
/**
 * Measure time task5 and task6 takes respectively for various input array sizes
 * to see the different efficiency for different algorithms.
 */
public class task7Main {

    // Function to fill an array with random integers between -10000 and 10000
    public static void populate(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(-10000, 10000); 
        }
    }

    public static void main(String[] args) {

        MethodTimer timer = new MethodTimer();
        int[] arraySizes = {500, 1000, 1500, 2000, 2500, 3000};

        for (int size : arraySizes) {
            System.out.println("Array size: " + size);

            // Creates an empty array with length.
            int[] a = new int[size];

            // Put random numbers in the array.
            populate(a);

            // Measure time for the task5 with MethodTimer created in task_3;
            double time = timer.measureTime(() -> {
                ThreeSumBruteforce.threeSum(a);
            });

            System.out.println(" Running time for task5: " + Math.round(time * 1000.0)/1000.0 + " seconds");

            // Measure time for the task6 with MethodTimer created in task_3;
            double time_2 = timer.measureTime(() -> {
                ThreeSumCaching.threeSum(a);
            });

            System.out.println(" Running time for task6: " + Math.round(time_2 * 1000.0)/1000.0 + " seconds");
        }
    }
}

