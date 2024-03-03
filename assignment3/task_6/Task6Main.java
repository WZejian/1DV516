package task_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task6Main {

    public static void printArray(int[] a){
        for ( int i=0; i<a.length; i++){
            System.out.print(a [i]+ " ");
        }
        System.out.println( );
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the array ");
        int answer = scanner.nextInt();
        Random random = new Random();


        int[] a = new int[answer];
        for (int i = 0; i < answer; i++) {
            a[i] = random.nextInt(0, 1000);
        }
        int [] b = Arrays.copyOf(a,a.length);

        if (a.length<=100){
            printArray(a);
        }

        long start = System.currentTimeMillis();
        MergeSortIterative.mergeSort(a);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Iterative version of Mergesort: a version that does not use recursion " + result + " milliseconds");
        if (a.length<=100){
            printArray(a);
        }

        long start2 = System.currentTimeMillis();
        MergeSortRecursive.mergeSort(b, 0, answer - 1, answer);
        long finish2 = System.currentTimeMillis();
        long result2 = finish2 - start2;
        System.out.println("Recursive version of Mergesort: a version that uses recursion " + result2 + " milliseconds");
        if (a.length<=100){
            printArray(b);
        }

    }
}
