package task_6;

import java.util.Random;
import java.util.Scanner;

public class MergeSortRecursive {
    // Method to merge two sorted sub arrays into one sorted array
    // left: The index of the left sub array.
    // middle: The index marking the end of the left subarray and the start of the right subarray.
    // right: The index of the right sub array.

    public static void merge(int[] arr, int left, int middle, int right, int size) {
        int i = left;
        int j = middle + 1;
        int n = left;

        int[] arrayAdditional = new int[size]; // Create a temporary array for merging

        // main step in the merge sort algorithm, it is repeated until
        // all elements from both sub arrays are merged into the temporary array.
        // Merge elements from the two sub arrays
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                arrayAdditional[n] = arr[i];
                i++;
            } else {
                arrayAdditional[n] = arr[j];
                j++;
            }
            n++;
        }


        // Copy remaining elements from the first subarray
        while (i <= middle) {
            arrayAdditional[n] = arr[i];
            i++;
            n++;
        }

        // Copy remaining elements from the second subarray
        while (j <= right) {
            arrayAdditional[n] = arr[j];
            j++;
            n++;
        }

        // Copy sorted elements back to the original array
        for (int d = left; d <= right; d++) {
            arr[d] = arrayAdditional[d];
        }
    }

    // Recursive merge sort method
    public static void mergeSort(int[] arr, int left, int right, int size) {
        if (left < right) {
            int mid = (left + right) / 2; // Calculate the middle
            // Recursively sort the first and second halves
            mergeSort(arr, left, mid, size);
            mergeSort(arr, mid + 1, right, size);
            // Merge the sorted halves
            merge(arr, left, mid, right, size);
        }
    }
}

