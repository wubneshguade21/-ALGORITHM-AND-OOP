/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;

/**
 *
 * @author SETEGN
 */
public class Car extends Vehicle {
    private int seatCount;
    private String fuelType;
    private double totalCharge;
    private int daysRented;

    public Car(String vehicleId, String brand, String fuelType, int seatCount) {
        super(vehicleId, brand, 0.0);
        this.fuelType = fuelType;
        this.seatCount = seatCount;
        this.rentalRate = calculateRateBasedOnFuel(fuelType);
    }

    private double calculateRateBasedOnFuel(String fuelType) {
        switch (fuelType.toLowerCase()) {
            case "petrol": return 50.0;
            case "diesel": return 60.0;
            case "electric": return 40.0;
            default: return 50.0;
                    
        }
    }

    public void rent(int days) {
        if (isAvailable) {
            isAvailable = false;
            this.daysRented = days;
            totalCharge = days * rentalRate;
            System.out.println("Car rented for " + days + " days.");
        } else {
            System.out.println("Car is not available.");
        }
    }

    public double returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;

            System.out.println("======= Car Rental Summary =======");
            System.out.println("Vehicle ID : " + vehicleId);
            System.out.println("Brand      : " + brand);
            System.out.println("Fuel Type  : " + fuelType);
            System.out.println("Seat Count : " + seatCount);
            System.out.println("Rate/Day   : $" + rentalRate);
            System.out.println("Days Rented: " + daysRented);
            System.out.println("Total Paid : $" + totalCharge);
            System.out.println("==================================");

            return totalCharge;
        } else {
            System.out.println("This car was not rented.");
            return 0.0;
        }
    }
    public void displayInfo() {
    System.out.println("Car - ID: " + vehicleId + ", Brand: " + brand + ", Availability: " + isAvailable);
}
}
