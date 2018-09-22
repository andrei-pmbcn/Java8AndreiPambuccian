package autoservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrei
 */
public class Car implements Saleable, Rentable {
    String name;
    String color;
    float speed;
    float salePrice = 0;
    float rentPrice = 0;

    public Car(String name, String color, float speed) {
        this.name = name;
        this.color = color;
        this.speed = speed;
    }
    
    public Car(String name, String color, float speed,
            float salePrice, float rentPrice) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.salePrice = salePrice;
        this.rentPrice = rentPrice;        
    }

    public String getName() {
        return name;
    }
    
    public void setName(String val) {
        name = val;        
    }
    
    public String getColor() {
        return color;        
    }
    
    public void setColor(String val) {
        color = val;
    }
    
    public float getSpeed() {
        return speed;
    }
    
    public void setSpeed(float val) {
        speed = val;
    }
    
    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float val) {
        salePrice = val;
    }

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float val) {
        rentPrice = val;
    }
}
