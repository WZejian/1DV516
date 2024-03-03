package task_4;

import task_3.InsertSort;
import task_5.MethodTimer;
import task_5.QuickSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Task4Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        System.out.println("Before sorting: " + Arrays.toString(arr));
        HeapSort.sort(arr);
        System.out.println("After Heap sorting: " + Arrays.toString(arr));
    }
}
