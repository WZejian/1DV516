package task_3;


import task_1.QuickFind;

import java.util.Random;

public class MethodTimerMain {

    private static MethodTimer timer = new MethodTimer();

    // Create a method to perform the operation and measure its execution time
    public static double measureConnected(QuickFind uf, int a, int b) {
        // Measure the execution time of the connected method.

        double time = timer.measureTime(() -> {
            uf.connected(a, b);
        });

        System.out.println(a + " and " + b + " is connected?: " + uf.connected(a, b));
        return time;
    }

    public static double measureUnion(QuickFind uf, int a, int b) {

        if (uf.connected(a, b)) {
            System.out.println(a + " and " + b + " has already been connected" );
            return 0.0;
        }

        double time = timer.measureTime(() -> {
            uf.union(a, b);
        });

        System.out.println("After union " + a + " and " + b + ": " + uf);

        return time;

    }

    public static double measureFind(QuickFind uf, int a) {
        double time = timer.measureTime(() -> {
            uf.find(a);
        });

        System.out.println("The root of " + a + " is in index of " + uf.find(a));

        return time;
    }


    public static void main(String[] args) {

        int size = 10;
        int number = 10;
        Random random = new Random();

        QuickFind uf = new QuickFind(size);

        double total_unionTime = 0;
        double total_findTime = 0;
        double total_connectedTime = 0;
        int count = 0;
        for (int i = 0; i < number; i++) {
            int a = random.nextInt(10);
            int b;
            do {
                b = random.nextInt(10);
            } while (a == b);

            double time1 = measureUnion(uf, a, b);
            double time2 = measureFind(uf, a);
            double time3 = measureConnected(uf, a, b);

            if (time1 != 0.0) {
                count++;
            }
            total_unionTime += time1;
            total_findTime += time2;
            total_connectedTime += time3;

            System.out.println("Time of union " + a + " and " + b + " is: " + time1);
            System.out.println("Time of find " + a + " is: " + time2);
            System.out.println("Time of check " + a + " and " + b + " is connected: " + time3 + "\n");
        }


        System.out.println("The average time of union operation is: " + (double) total_unionTime/count);
        System.out.println("The average time of find operation is: " + (double) total_findTime/number);
        System.out.println("The average time of check connection is: " + (double) total_connectedTime/number);

    }
}
