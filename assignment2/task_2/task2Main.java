package task_2;

import java.util.Scanner;

public class task2Main {

    public static void main(String[] args) {
        int n = 10;
        // Create a new RandomQueue with a maximum capacity of 10
        RandomQueue randomQueue = new RandomQueue(n);
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("1. Enqueue number");
            System.out.println("2. Dequeue number");
            System.out.println("3. Check if it's empty");
            System.out.println("4. Get the size");
            System.out.println("5. Show elements");


            // Read the user's choice
            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Enter the number:");
                    int number = scanner.nextInt();
                    randomQueue.enqueue(number); //Add a number to the queue
                    break;
                case 2:
                    if (!randomQueue.isEmpty()) {
                        System.out.println("Dequeue result: " + randomQueue.dequeue());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    if (randomQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 4:
                    System.out.println("Size is " + randomQueue.size());// Display the size of the queue
                    break;
                case 5:
                    System.out.println("Elements in the queue:");
                    for ( Integer p: randomQueue){
                        System.out.print(p+" ");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
    }
}
