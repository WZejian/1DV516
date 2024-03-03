package task_3;

/**
 * Insert sorting by moving one element in the inordered sequence to the ordered sequence
 * in the right place until all the elements checked.
 */
public class InsertSort {
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        insertSort(arr, left, right);
    }

    public static void insertSort(int[] arr, int left, int right) {
        for(int i = left + 1; i <= right; i++)  {
            int insertVal = arr[i];
            int insertIdx = i - 1;
            //From right to left to check
            while(insertIdx >= 0 && insertVal < arr[insertIdx]) {
                arr[insertIdx + 1] = arr[insertIdx];
                insertIdx--;
            }
            //Avoid unnecessary repeated assignment.
            if(insertIdx != i - 1) {
                arr[insertIdx + 1] = insertVal;
            }

        }
    }
}
