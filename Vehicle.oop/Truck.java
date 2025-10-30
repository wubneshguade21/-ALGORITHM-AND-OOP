/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;

/**
 *
 * @author SETEGN
 */
public class Truck extends Vehicle{
    private double loadCapacity; 
    private double totalCharge;
    private int daysRented;

    public Truck(String vehicleId, String brand, double loadCapacity) {
        super(vehicleId, brand, 0.0);
        if (loadCapacity <= 0){
            throw new IllegalArgumentException("Loaded capacity must be positive.");
        }
        this.loadCapacity = loadCapacity;
        this.rentalRate = calculateRateBasedOnCapacity(loadCapacity);
    }

    private double calculateRateBasedOnCapacity(double capacity) {
        if (capacity <= 5) return 80.0;
        else if (capacity <= 10) return 120.0;
        else return 150.0;
    }
    
    public void rent(int days) {
        if (isAvailable) {
            isAvailable = false;
            this.daysRented = days;
            totalCharge = days * rentalRate;
            System.out.println("Truck rented for " + days + " days.");
        } else {
            System.out.println("Truck is not available.");
        }
    }

    public double returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
        System.out.println("======= Truck Rental Summary =======");
            System.out.println("Vehicle ID   : " + vehicleId);
            System.out.println("Brand        : " + brand);
            System.out.println("Load Capacity: " + loadCapacity + " tons");
            System.out.println("Rate/Day     : $" + rentalRate);
            System.out.println("Days Rented  : " + daysRented);
            System.out.println("Total Paid   : $" + totalCharge);
            System.out.println("====================================");

            return totalCharge;
        } else {
            System.out.println("This truck was not rented.");
            return 0.0;
        }
    }
    @Override
        public void displayInfo() {
    System.out.println("Truck - ID: " + vehicleId + ", Brand: " + brand
            + " Availability: " + isAvailable );
}
}
