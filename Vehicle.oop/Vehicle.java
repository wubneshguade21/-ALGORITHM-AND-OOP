/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;

/**
 *
 * @author SETEGN
 */
public abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected boolean isAvailable;
    protected double rentalRate;

    public Vehicle(String vehicleId, String brand, double rentalRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    public double getRentalRate() {
        return rentalRate;
    }
    public abstract void rent(int days);           
    public abstract double returnVehicle();      

    void displayInfo(){
        
    }
}