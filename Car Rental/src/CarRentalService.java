import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalService {
//    The system should allow reservation of a car of a given type at a desired date and time for a given number of days.
//    There are 3 types of cars (sedan, SUV and van).
//    The number of cars of each type is limited.
//    Use unit tests to prove the system satisfies the requirements.

    private List<Customer> customers;
    private List<Rental> rentals;
    private List<Car> cars;


    CarRentalService (){
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        cars = new ArrayList<>();
    }


    void addCarsDB(){
        Car car = new Car("A1", new SUV("Mbe03"), 50.0);
        Car car1 = new Car("A2", new Sedan("Mabc"), 50.0);
        Car car2 = new Car("A3", new Van("MRE"), 50.0);
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
    }

    void addCustomer(Customer customer){
        customers.add(customer);
    }

    //reserve a car
    public  void rentACar(Customer customer,Car car, String pickUpDateAndTIme, int days) throws Exception {
        //Check Car availability
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(customer, car, days, pickUpDateAndTIme));

        } else {
            System.out.println("Sorry this car is not available");
            throw new Exception("Car is not available exception");
        }

    }

    public void displayRentalService() {
        //Add cars to the DB
        addCarsDB();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. No Thanks");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("\n== Rent a Car ==\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Cars:");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getCarType().toString());
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = scanner.nextLine();

                System.out.print("Enter the pick up date and time in this format YYYY-MM-DD HH:MM: ");
                String pickUpDateAndTime = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("C1" + (customers.size() * 2), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePricePerDays(rentalDays);
                    System.out.println("\n==== Rental Information ====\n");
                    System.out.println("Customer ID: " + newCustomer.getId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getCarId() + selectedCar.getCarType().toString());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        try {
                            rentACar(newCustomer, selectedCar, pickUpDateAndTime,rentalDays);
                        } catch (Exception e) {
                            throw new RuntimeException("Car is not available");
                        }
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }


}


