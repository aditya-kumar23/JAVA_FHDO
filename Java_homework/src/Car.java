import java.io.*;
import java.util.*;
public class Car {
    private int id;
    private String make;
    private String model;
    private int year; 
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Getters for class properties
    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
    public String getRegistrationNumber (){
        return registrationNumber;
    }

    public static void main(String[] args) {
        Car[] cars = {
            new Car(1, "Toyota", "Camry", 2018, "Red", 18000, "ABC123"),
            new Car(2, "Honda", "Civic", 2017, "Blue", 16000, "XYZ789"),
            new Car(3, "Ford", "Mustang", 2020, "Black", 25000, "DEF456"),
            new Car(4, "Toyota", "Corolla", 2019, "White", 19000, "GHI789"),
            new Car(5, "Toyota", "Fortuner", 2018, "Red", 20000, "ABZ387"),
            new Car(6, "Honda", "CR-V", 2017, "Blue", 17000, "LPD789"),
            new Car(6, "BMW", "X1", 2016, "Black", 40000, "UP16496"),
            new Car(8, "TATA", "Safari", 2022, "White", 15000, "DL347809")
        };

        filterAndSaveByMake(cars, "Toyota");
        filterAndSaveByModelAndAge(cars, "CR-v", 4);
        filterAndSaveByYearAndPrice(cars, 2016, 17000);
    }

    public static void filterAndSaveByMake(Car[] cars, String make) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile("CarsByMake_" + make + ".txt", filteredCars);
    }

    public static void filterAndSaveByModelAndAge(Car[] cars, String model, int age) {
        List<Car> filteredCars = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear() > age)) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile("CarsByModelAndAge_" + model + "_" + age + "YearsOld.txt", filteredCars);
    }

    public static void filterAndSaveByYearAndPrice(Car[] cars, int year, double minPrice) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > minPrice) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile("CarsByYearAndPrice_" + year + "_" + minPrice + ".txt", filteredCars);
    }

    public static void saveCarsToFile(String filename, List<Car> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.println("Make: " + car.getMake());
                writer.println("Model: " + car.getModel());
                writer.println("Year: " + car.getYear());
                writer.println("Color: " + car.getColor());
                writer.println("Price: $" + car.getPrice());
                writer.println("Registration Number: " + car.getRegistrationNumber());
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}