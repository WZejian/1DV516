package task_1;

import java.util.Scanner;

public class Task1Main {
    public static void main(String[] args) {

        // Create a hash table to store key-value pairs
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println(" Size of Hash table is 10 (Class MyHashTable, Inital_Capacity)");
            System.out.println(" 1.insert elements ");
            System.out.println(" 2.find elements ");
            System.out.println(" 3.delete elements ");
            System.out.println(" 4.show all elements which are in the Hashtable ");

            try {
                int answer = Integer.parseInt(scanner.nextLine());

                switch (answer) {
                    case 1:
                        System.out.println("To insert element  please write key (String) and value(integer)");
                        System.out.println("write key (String) ");
                        String replyKey = scanner.nextLine();
                        System.out.println("write value (integer) ");
                        int replyValue = Integer.parseInt(scanner.nextLine());
                        // Insert the key-value pair into the hash table
                        hashTable.insert(replyKey, replyValue);
                        break;

                    case 2:
                        System.out.println("Enter key ");
                        String replyKey2 = scanner.nextLine();
                        // Get and display the value associated with the given key
                        int value = hashTable.get(replyKey2);
                        System.out.println("this element has been found " + value);
                        break;

                    case 3:
                        System.out.println("Enter key ");
                        String replyKey3 = scanner.nextLine();
                        // Remove the element associated with the given key
                        hashTable.remove(replyKey3);
                        System.out.println(" this element has been removed");
                        break;

                    case 4:
                        System.out.println("the elements in the table ");
                        // Display all elements in the hash table
                        hashTable.showElements();
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
