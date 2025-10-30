/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;
import java.util.ArrayList;
/**
 *
 * @author SETEGN
 */
public class RentalManager {

    private ArrayList<Vehicle> vehicles;
    private double totalEarnings;
    private ArrayList<Customer> customers;

    public RentalManager() {
        vehicles = new ArrayList<>();
        totalEarnings = 0.0;
        customers = new ArrayList<>();
    }
    public void registerCustomer(String name, String id) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("Customer id cannot be empty");
        }
        for (Customer c : customers) {
            if (c.getCustomerId().equalsIgnoreCase(id)) {
                throw new IllegalArgumentException("Customer ID already exists.");
            }
        }
        customers.add(new Customer(name, id));
        System.out.println("Customer registered successfully.");
    }
    
   public void addVehicle(Vehicle v){
       for (Vehicle exist : vehicles){
           if(exist.getVehicleId().equalsIgnoreCase(v.getVehicleId())){
               throw new IllegalArgumentException("Vehicle id already exist: " + v.getVehicleId());
           }
       }
       vehicles.add(v);
       System.out.println(v.getClass().getSimpleName() + " With id " + v.getVehicleId() + " Added sueccess fully");
   }
    public void displayAvailableVehicles() {
        System.out.println("===== Available Vehicles =====");
         for (Vehicle v : vehicles) {
           if (v.isAvailable()) {
            v.displayInfo();  
           }
         }

        System.out.println("==============================");
    }

  public void rentVehicle(String customerId, String vehicleId, int days) throws InvalidVehicleException {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (customer.hasActiveRental()) {
            System.out.println("Customer already has an active rental.");
            return;
        }
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(vehicleId)) {
                if (v.isAvailable()) {
                    v.rent(days);
                    customer.setHasActiveRental(true);
                    System.out.println("Vehicle rented successfully.");
                    return;
                } else {
                    throw new InvalidVehicleException("Vehicle is not available.");
                }
            }
        }
        throw new InvalidVehicleException("Vehicle with ID " + vehicleId + " not found.");
    }


     public void returnVehicle(String customerId, String vehicleId)throws InvalidVehicleException {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(vehicleId)) {
                if (!v.isAvailable()) {
                    double charge = v.returnVehicle();
                    totalEarnings += charge;
                    customer.setHasActiveRental(false);
                    System.out.println("Vehicle returned. Charge: $" + charge);
                    return;
                } else {
                    throw new InvalidVehicleException("This vehicle was not rented.");
                }
            }
        }
        throw new InvalidVehicleException("Vehicle with ID " + vehicleId + " not found.");
    }

     public void displayCustomers() {
        System.out.println("===== Registered Customers =====");
        for (Customer c : customers) {
            System.out.println("Name: " + c.getName() + ", ID: " + c.getCustomerId() + ", Active Rental: " + c.hasActiveRental());
        }
        System.out.println("================================");
    }

    private Customer getCustomerById(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
     
    public void showTotalEarnings() {
        System.out.println(" Total Earnings: $" + totalEarnings);
    }
}
