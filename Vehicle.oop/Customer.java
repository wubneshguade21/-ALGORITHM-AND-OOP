/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.project;

/**
 *
 * @author SETEGN
 */
public class Customer {
    private String name;
    private String customerId;
    private boolean hasActiveRental;

    public Customer(String name, String customerId) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Customer name can not be null or empty.");
        }
        if(customerId == null || customerId.isEmpty()){
            throw new IllegalArgumentException("Customer id  cannot be null or empty");
        }
        this.name = name;
        this.customerId = customerId;
        this.hasActiveRental = false;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
    
    public boolean hasActiveRental() {
        return hasActiveRental;
    }

    public void setHasActiveRental(boolean hasRental) {
        this.hasActiveRental = hasRental;
    }

    }
