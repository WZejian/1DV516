package task_5;

import task_3.InsertSort;
import task_4.HeapSort;

public class Task5Main {

    public static void main(String[] args) {

        MethodTimer timer = new MethodTimer();

        int[] inputSizes = { 10000, 20000, 40000, 60000, 80000, 100000 };
        int[] depths = new int[30];

        for (int i = 0; i < depths.length; i++) {
            depths[i] = i+1;

        }

        for (int size : inputSizes) {
            System.out.println("*******Array Size: " + size + "********");
            int[] arr = generateRandomArray(size);

            for (int depth : depths) {
                int sum1= 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
                for (int i = 0; i < 10; i++) {
                    double duration1 = timer.measureTime(() -> {
                        QuickSort.sort(arr.clone());
                    });

                    double duration2 = timer.measureTime(() -> {
                        InsertSort.sort(arr.clone());
                    });

                    double duration3 = timer.measureTime(() -> {
                        HeapSort.sort(arr.clone());
                    });

                    double duration4 = timer.measureTime(() -> {
                        QuickToHeapSort.sort(arr.clone(), depth);
                    });

                    double duration5 = timer.measureTime(() -> {
                        QuickToInsertSort.sort(arr.clone(), depth);
                    });

                    sum1 += duration1;
                    sum2 += duration2;
                    sum3 += duration3;
                    sum4 += duration4;
                    sum5 += duration5;

                }

                System.out.println("Average Pure Quick sorting Time: " + sum1/10 + " ns");
                System.out.println("Average Pure Insert soring Time: " + sum2/10 + " ns");
                System.out.println("Average Pure Heap sorting Time: " + sum3/10 + " ns");
                System.out.println("Depth: " + depth + ", Average QuickToHeap sorting Time: " + sum4/10 + " ns");
                System.out.println("Depth: " + depth + ", Average QuickToInsert sorting Time: " + sum5/10 + " ns");
                System.out.println();

            }
            System.out.println("--------------------------------------");
        }

    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }

}

