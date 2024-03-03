package task_4;

import task_1.QuickFind;
import task_2.QuickUnion;
import task_3.MethodTimer;
import java.util.Random;

/**
 * Measures union time for various input array sizes by different algorithm in task1 and task2. 
 */
public class task4Main {

    private static MethodTimer timer = new MethodTimer();

    public static double measureUnion_task1(QuickFind qf, int a, int b) {

        double time = timer.measureTime(() -> {
            qf.union(a, b);
        });

        return time;

    }

    public static double measureUnion_task2(QuickUnion uf2, int a, int b) {

        double time = timer.measureTime(() -> {
            uf2.union(a, b);
        });

        return time;

    }


    public static void main(String[] args) {

        Random random = new Random();

        int[] arraySizes = { 50000, 100000, 150000, 200000};
        int[] numUnions = { 500, 1000, 1500, 2000};

        for (int size : arraySizes) {
            QuickFind qf = new QuickFind(size);
            QuickUnion qu = new QuickUnion(size);
            for (int numUnion : numUnions) {
                double total_unionTime = 0;
                double total_unionTime_2 = 0;
                for (int i = 0; i < numUnion; i++) {
                    int a = random.nextInt(size);
                    int b = random.nextInt(size);
                    total_unionTime += measureUnion_task1(qf, a, b);
                    total_unionTime_2 += measureUnion_task2(qu, a, b);
                }
                System.out.println(numUnion + " Union operations time by QuickFind in array size of " + size + " is "
                        + total_unionTime );
                System.out.println(numUnion + " Union operations time by QuickUnion in array size of " + size + " is "
                        + total_unionTime_2 + "\n");

            }

        }

    }
}
