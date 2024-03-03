package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Task2Main {

    // create random plate numbers
    public static String createNumbers(){
        Random random = new Random();
        String number = "";
        for (int i=0; i<3; i++){
            char c = (char) random.nextInt('A','Z'+1);
            number+=c;
        }
        number +=random.nextInt(100, 1000);
        return number;
    }


    public static void main(String[] args) {

        // Create a hash table to store vehicle information
        MyHashTable<Car, Integer> vehicleTable = null;

        // Generate random vehicle data and add them to the hash table
        Random rand = new Random();

        List <Car> listCars = new ArrayList<>();

        while (true){

            System.out.println ("1. create size of the hash table ");
            System.out.println ("2. insert vehicles  ");
            System.out.println("3. delete vehicles   ");
            System.out.println("4. show elements  ");
            Scanner scanner=new Scanner(System.in);
            int answer = scanner.nextInt();

            if (answer ==1){
                System.out.println("enter the size of the hash table ");
                int tableSize = scanner.nextInt();
                vehicleTable = new MyHashTable<>(tableSize);

            }else if (answer == 2) {
                System.out.println("enter the number of vehicles to insert ");
                int numVehicles = scanner.nextInt();
                for (int i = 0; i < numVehicles; i++) {
                    String plateNumber = createNumbers();
                    String color = "Color" + rand.nextInt(10); // Random color
                    int year = 2000 + rand.nextInt(20); // Random year
                    String make = "Make" + rand.nextInt(5); // Random make

                    // Create a Car object and add it to the hash table
                    Car car = new Car(plateNumber, color, year, make);
                    vehicleTable.insert(car, i);
                    listCars.add(car);
                }
                // Analyze the hash function's performance
                int conflicts = vehicleTable.getConflicts();
                int offset = vehicleTable.getOffset();
                System.out.println("Number of Conflicts: " + conflicts);
                System.out.println("Number of  Offsets: " + offset);
                System.out.println("Load factor " + vehicleTable.loadFactor());


            }else if (answer ==3) {
                System.out.println("Enter the number of vehicles to delete: ");
                int deleteVehicles = scanner.nextInt();
                Random random = new Random();
                for (int i=0; i<deleteVehicles; i++){
                    int index= random.nextInt(listCars.size());
                    Car car = listCars.get(index);
                    if (vehicleTable.contains(car)){
                        vehicleTable.remove(car);
                        listCars.remove(index);
                    }

                }

            }else if (answer ==4){
                vehicleTable.showElements();
            }else {
                System.out.println("you wrote not correct number");
            }
        }
    }
}
