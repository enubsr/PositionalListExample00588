/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package position;

/**
 *
 * @author Enubs
 */
public class Product {
    private String description;
    private double price;

    public Product(String description, double price){
        this.description = description;
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    
}
