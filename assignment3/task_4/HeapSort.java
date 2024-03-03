package task_4;

/**
 * HeapSorting by building max heap, swap the last element and the root element, and sink the root element to
 * the right place and repeat those steps until all the elements in the heap checked.
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        heapSort(arr, lo, hi);
    }

    /**
     * HeapSorting from the last element to the root element.
     */
    public static void heapSort(int[] arr, int lo, int hi) {
        maxHeapBuild(arr, lo, hi);
        for (int i = hi; i > lo; i--) {
            swap(arr, lo, i);
            sink(arr, lo, i - 1, lo);
        }

    }

    /**
     * Build max heap.
     */
    private static void maxHeapBuild(int[] arr, int lo, int hi) {
        for (int i = (hi - lo + 1) / 2; i >= 0 ; i--) {// The last non-leaf node.
            sink(arr, lo, hi, lo + i);
        }
    }

    /**
     * Let the root element be the right place after swap the root element and the last element.
     */
    private static void sink(int[] arr, int lo, int hi, int i) {
        int left = 2 * (i - lo) + 1 + lo;
        int right = left + 1;
        int max = i;
        if(left <= hi && arr[left] > arr[max]) {
            max = left;
        }
        if(right <= hi && arr[right] > arr[max]) {
            max = right;
        }
        if(max != i) {
            swap(arr, i, max);
            sink(arr, lo, hi, max);
        }
    }

    /**
     * Swap two elements according to their index.
     */
    private static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}


