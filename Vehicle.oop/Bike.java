/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;

/**
 *
 * @author SETEGN
 */
public class Bike extends Vehicle {
    private boolean hasCarrier;
    private String fuelType;
    private double totalCharge;
    private int daysRented; 

    public Bike(String vehicleId, String brand, String fuelType, boolean hasCarrier) {
        super(vehicleId, brand, 0.0);
        this.fuelType = fuelType;
        this.hasCarrier = hasCarrier;
        this.rentalRate = calculateRateBasedOnFuel(fuelType);
    }

    private double calculateRateBasedOnFuel(String fuelType) {
        switch (fuelType.toLowerCase()) {
            case "petrol": return 25.0;
            case "electric": return 20.0;
            case "manual": return 10.0;
            default: return 25.0;
        }
    }

 
    public void rent(int days) {
        if (isAvailable) {
            isAvailable = false;
            this.daysRented = days;
            totalCharge = days * rentalRate;
            System.out.println("Bike rented for " + days + " days.");
        } else {
            System.out.println("Bike is not available.");
        }
    }
    
    
    public double returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;

            System.out.println("======= Bike Rental Summary =======");
            System.out.println("Vehicle ID : " + vehicleId);
            System.out.println("Brand      : " + brand);
            System.out.println("Fuel Type  : " + fuelType);
            System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
            System.out.println("Rate/Day   : $" + rentalRate);
            System.out.println("Days Rented: " + daysRented);
            System.out.println("Total Paid : $" + totalCharge);
            System.out.println("===================================");

            return totalCharge;
        } else {
            System.out.println("This bike was not rented.");
            return 0.0;
        }
    }
    public void displayInfo() {
    System.out.println("Bike - ID: " + vehicleId + ", Brand: " + brand + "Availability: " + isAvailable );
}

}
