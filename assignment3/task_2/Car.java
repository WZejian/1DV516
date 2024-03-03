package task_2;

import java.util.Objects;

public class Car {

    private String plateNumber;
    private String colour;
    private int year;
    private String marka;

    public String getPlateNumber() {
        return plateNumber;
    }

    // Constructor to initialize Car object
    public Car(String plateNumber, String colour, int year, String marka) {
        this.plateNumber = plateNumber;
        this.colour = colour;
        this.year = year;
        this.marka = marka;
    }

    // Getters and setters for Car attributes
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }


    // toString method to provide a formatted string representation of the Car
    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", marka='" + marka + '\'' +
                '}';
    }


    // method to compare Car objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && plateNumber.equals(car.plateNumber) && colour.equals(car.colour) && marka.equals(car.marka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, colour, year, marka);
    }
}
