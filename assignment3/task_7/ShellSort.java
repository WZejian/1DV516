package task_7;

public class ShellSort {

    ;

    public static void ShellSort1(int[] mass) {
        int comparisons = 0;
        int swaps = 0;

        int tmp;
        // Determine the initial step as half of the array length
        for (int step = mass.length / 2; step > 0; step /= 2)
            for (int i = step; i < mass.length; i++) {
                tmp = mass[i];
                int j;
                for (j = i; j >= step; j -= step) {
                    comparisons++;
                    if (tmp < mass[j - step]) {
                        mass[j] = mass[j - step];
                        swaps++;
                    }else
                        break;
                }
                mass[j] = tmp;
            }
        System.out.println();
        System.out.println("ShellSort1 results: ");
        System.out.println();
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println();

    }

    // ShellSort2 using custom gap sequence defined in array 'a'
    public static void shellSort2(int[] mass) {
        System.out.println();
        System.out.println("ShellSort2 results: ");
        int[] a = {9, 5, 3, 2, 1};
        sortShell(mass, a);
        System.out.println();

    }


    // ShellSort using Ciura's gap sequence
    public static void shellSortCiura(int[] mass) {

        System.out.println();
        System.out.println("ShellSortCiura results: ");
        // Implement Ciura's gap sequence
        int[] ciuraGaps = {701, 301, 132, 57, 23, 10, 4, 1}; // Ciura's Gap Sequence
        sortShell(mass, ciuraGaps);
        System.out.println();

    }

    public static void sortShell(int[] mass, int [] massGaps) {
        int comparisons = 0;
        int swaps = 0;
        // Implement Ciura's gap sequence

        for (int gap : massGaps) {
            for (int i = gap; i < mass.length; i++) {
                int tmp = mass[i];
                int j = i;
                while (j >= gap && mass[j - gap] > tmp) {
                    comparisons++;
                    mass[j] = mass[j - gap];
                    swaps++;
                    j -= gap;
                }
                mass[j] = tmp;
            }
        }
        System.out.println();
        System.out.println("ShellSort Comparisons: " + comparisons);
        System.out.println("ShellSort Swaps: " + swaps);

    }

    // ShellSort using Tokuda's gap sequence
    public static void shellSortTokuda(int[] mass) {
        int comparisons = 0;
        int swaps = 0;

        // Implement Tokuda's gap sequence
        double h = 1;
        int size = mass.length;
        while (h < size) {
            h = 2.25 * h + 1;
        }
        while (h > 0) {
            for (double i = h; i < size; i++) {
                int tmp = mass[(int) i];
                double j = i;
                while (j >= h && mass[(int) (j - h)] > tmp) {
                    comparisons++; // Use the class-level comparisons variable
                    mass[(int) j] = mass[(int) (j - h)];
                    swaps++; // Use the class-level swaps variable
                    j -= h;
                }
                mass[(int) j] = tmp;
            }
            h = (int) (h / 2.25);
        }
        System.out.println();
        System.out.println("ShellSortTokuda Comparisons: " + comparisons);
        System.out.println("ShellSortTokuda Swaps: " + swaps);
    }
}

