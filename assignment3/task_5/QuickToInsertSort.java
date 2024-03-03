package task_5;

import java.util.Arrays;
import task_3.InsertSort;
import task_4.HeapSort;

/**
 * This class has a depth parameter in a method and only used to do swapping
 * to insert sort from quick sort at a given depth.
 */
public class QuickToInsertSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        QuickToInsertSort.sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int depth) {

        introSort(arr, 0, arr.length - 1, depth);
    }

    /**
     * Change to insert sort from quick sort at a depth.
     */
    public static void introSort(int[] arr, int left, int right, int depth) {

        if (depth == 0) {
            //HeapSort.heapSort(arr, left, right);
            InsertSort.insertSort(arr,left,right);
        } else {
            if(left < right) {
                int pivotIdx = partitionIdx(arr, left, right);
                introSort(arr, left, pivotIdx - 1, depth-1);
                introSort(arr, pivotIdx + 1, right, depth-1);
            }

        }
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

