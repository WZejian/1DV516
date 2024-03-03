package task_1;

import java.util.Scanner;

public class task1Main {
    public static void main(String[] args) {
        // Create an instance of UserDoubleEndedQueue to work with integer values
        UserDoubleEndedQueue <Integer> q = new UserDoubleEndedQueue<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println ( "1. Write the size ");
            System.out.println ( "2. Add last");
            System.out.println ( "3. Add first");
            System.out.println ( "4. Check is it empty or not ");
            System.out.println ( "5. Remove first ");
            System.out.println ( "6. Remove last ");
            System.out.println ( "7. Show on the screen ");
            int answer = scanner.nextInt();

            if ( answer == 1){
                System.out.println("Size is " + q.size());
            }
            else if ( answer == 2) {
                System.out.println("Enter the number");
                int  number = scanner.nextInt();
                q.addLast(number);

            } else if (answer == 3 ){
                System.out.println("Enter the number");
                int  number = scanner.nextInt();
                q.addFirst(number);
            } else if ( answer == 4){
                 if (q.isEmpty()){
                     System.out.println("list is empty");
                 }
                 else{
                     System.out.println("list is NOT empty");
                 }
            }else if ( answer == 5){
                q.removeFirst();

            }else if ( answer == 6){
                q.removeLast();
            }
            else {
                for (Integer p: q){
                    System.out.print(p + " ");
                }
                System.out.println();
            }

        }

    }
}
