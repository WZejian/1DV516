package task_6;

import java.util.Random;
import java.util.Scanner;

public class MergeSortIterative {
    // Method to merge two sorted sub arrays into one sorted array
    public static void merge(int[] arr, int left, int middle, int right) {
        // Calculate the sizes of the two sub arrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays for the left and right subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data from the original array to the temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        // Merge the two sub arrays back into the original array
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            // Compare elements from the two sub arrays and merge them
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Method to perform iterative merge sort
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        for (int currentSize = 1; currentSize <= n - 1; currentSize = 2 * currentSize) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currentSize) {
                // Calculate the middle and right end indices for merging
                int mid = Math.min(leftStart + currentSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currentSize - 1, n - 1);

                merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

}
