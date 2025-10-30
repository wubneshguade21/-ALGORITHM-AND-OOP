/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehicle.project;
 import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author SETEGN
 */
public class RentalSystemApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalManager manager = new RentalManager();
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== Vehicle Rental System ======");
             System.out.println("1. Register Customer");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Display Available Vehicles");
            System.out.println("4. Rent a Vehicle");
            System.out.println("5. Return a Vehicle");
             System.out.println("6. Show Customers");
            System.out.println("7. Show Total Earnings");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String cid = sc.nextLine();
                    try{
                       manager.registerCustomer(cname, cid); 
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try{
                    System.out.print("Enter vehicle type (Car/Bike/Truck): ");
                    String type = sc.nextLine();

                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();

                    if (type.equalsIgnoreCase("Car")) {
                        System.out.print("Fuel Type (Petrol/Diesel/Electric): ");
                        String fuel = sc.nextLine();
                         
                        System.out.print("Seat Count: ");
                        int seats = sc.nextInt();

                        manager.addVehicle(new Car(id, brand, fuel, seats));
                    } else if (type.equalsIgnoreCase("Bike")) {
                        System.out.print("Fuel Type (Petrol/Manual/Electric): ");
                        String fuel = sc.nextLine();

                        System.out.print("Has Carrier? (true/false): ");
                        boolean hasCarrier = sc.nextBoolean();

                        manager.addVehicle(new Bike(id, brand, fuel, hasCarrier));
                    } else if (type.equalsIgnoreCase("Truck")) {
                        System.out.print("Load Capacity (in tons): ");
                        double capacity = sc.nextDouble();

                        manager.addVehicle(new Truck(id, brand, capacity));
                    } else {
                        System.out.println("Invalid vehicle type.");
                    } 
                    
              }catch (IllegalArgumentException e){
                            System.out.println("Error: " + e.getMessage());
                            }catch(InputMismatchException e){
                                System.out.println("input type mismatch. please enter the correct data.");
                                sc.nextLine();
                            }
                    break;

                case 3:
                    manager.displayAvailableVehicles();
                    break;

               case 4:
                    System.out.print("Enter Customer ID: ");
                    String rentCid = sc.nextLine();
                    System.out.print("Enter Vehicle ID to rent: ");
                    String rentId = sc.nextLine();
                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();
                    
                    try{
                    manager.rentVehicle(rentCid, rentId, days);
                    }catch (InvalidVehicleException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    String returnCid = sc.nextLine();
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnId = sc.nextLine();
                    
                    try{
                      manager.returnVehicle(returnCid, returnId);
                    }catch(InvalidVehicleException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    manager.displayCustomers();
                    break;
                    
                case 7:
                    manager.showTotalEarnings();
                    break;

                case 8:
                    exit = true;
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
} 
