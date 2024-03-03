package task_3;

import task_4.HeapSort;
import task_5.QuickSort;
import task_5.MethodTimer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Task3Main {
    public static void main(String[] args) {

        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        System.out.println("Before sorting: " + Arrays.toString(arr));
        InsertSort.sort(arr);
        System.out.println("After insert sorting: " + Arrays.toString(arr));

    }
}
