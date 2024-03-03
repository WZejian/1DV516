package task_7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task7Main {

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Allow the user to enter the size of the array multiple times
        for (int i = 1; i <= 6; i++) {
            System.out.println("Enter size of the array (Attempt " + i + "):");
            int answer = scanner.nextInt();

            Random random = new Random();
            int[] a = new int[answer];
            for (int j = 0; j < answer; j++) {
                a[j] = random.nextInt(0, 1000);
            }

            int[] b = Arrays.copyOf(a, a.length);
            int[] c = Arrays.copyOf(a, a.length);
            int[] d = Arrays.copyOf(a, a.length);

            if (answer <= 100) {
                printArray(a);
            }

            long start = System.currentTimeMillis();
            ShellSort.ShellSort1(a);
            long finish = System.currentTimeMillis();
            long result = finish - start;
            System.out.println("Time ShellSort1 " + result + " milliseconds");

            if (answer <= 100) {
                printArray(a);
            }

            long start2 = System.currentTimeMillis();
            ShellSort.shellSort2(b);
            long finish2 = System.currentTimeMillis();
            long result2 = finish2 - start2;
            System.out.println("Time ShellSort2 " + result2 + " milliseconds");

            if (answer <= 100) {
                printArray(b);
            }

            // Perform ShellSort with Ciura's gap sequence

            long startCiura = System.currentTimeMillis();
            ShellSort.shellSortCiura(c);
            long finishCiura = System.currentTimeMillis();
            long resultCiura = finishCiura - startCiura;
            System.out.println("Time ShellSort with Ciura's Gap Sequence " + resultCiura + " milliseconds");

            if (answer <= 100) {
                printArray(c);
            }

            // Perform ShellSort with Tokuda's gap sequence

            long startTokuda = System.currentTimeMillis();
            ShellSort.shellSortTokuda(d);
            long finishTokuda = System.currentTimeMillis();
            long resultTokuda = finishTokuda - startTokuda;
            System.out.println("Time ShellSort with Tokuda's Gap Sequence " + resultTokuda + " milliseconds");

            if (answer <= 100) {
                printArray(d);
            }
        }
    }
}
