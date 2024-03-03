package task_5;

import java.util.Arrays;

/**
 * This class is pure quick sorting for the comparison among all other sorting algrithms,
 * hence there's no "depth" parameter. It is for presenting the experiment results more straight
 * forward and precise. The "depth" parameter is in the QuickToHeap Sort class and QuickToInsert Sort
 * class as they need depth parameter to change to heap sorting or insert sorting from quick sorting.
 * All three class's functions are almost the same, the only difference is the sort method with depth
 * parameter.
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * No "depth" parameter here as it was a pure quick sort class
     * The "depth" parameter are in the QuickToHeapSort and QuickToInsertSort classes.
     */
    public static void sort(int[] arr) {
        quickRec(arr, 0, arr.length - 1);
    }

    /**
     * Recursively quick sorting an array.
     */
    public static void quickRec(int[] arr, int left, int right) {

        if(left >= right) {
            return;
        }

        int pivotIdx = partitionIdx(arr, left, right);
        quickRec(arr, left, pivotIdx - 1);
        quickRec(arr, pivotIdx + 1, right);
    }


    /**
     * Lets the values smaller than the median value be the left and larger values be the
     * right place and finally return the index of median value.
     */
    public static int partitionIdx(int[] a, int left, int right) {
        int medianIdx = medianOfThree(a, left, right);
        int medianVal = a[medianIdx];
        swap(a, medianIdx, right);
        int p = left;
        for (int i = left; i < right; i++) {
            if (a[i] <= medianVal) {
                swap(a, p, i);
                p += 1;
            }
        }

        swap(a, p, right);
        return p;

    }

    /**
     * Swap the value by their index.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Return the median value in the given low index and high index in a sub array.
     */
    public static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        return mid;
    }

}

