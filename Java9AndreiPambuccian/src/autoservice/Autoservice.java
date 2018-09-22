/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoservice;

import java.util.Arrays;

/**
 *
 * @author andrei
 */
public class Autoservice {
    static Car[] cars;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            Car car1 = new Car("Honda", "green", 240, 10000, 200);
            Car car2 = new Car("Toyota", "red", 250, 12000, 220);
            Car car3 = new Car("Ford", "yellow", 260, 14000, 240);
            
            cars = new Car[3];
            cars[0] = car1;
            cars[1] = car2;
            cars[2] = car3;
            
            System.out.println("#######Before edit:#######");
            
            displayAutoservice();


            
            car1.setSpeed(car1.getSpeed() + 10);
            car2.setSpeed(car2.getSpeed() - 10);
            car3.setRentPrice(car3.getRentPrice() + 15);
            car3.setSalePrice(car3.getSalePrice() - 1200);
                    
            System.out.println("#######After edit:#######");
            
            displayAutoservice();
    }
    
    private static void displayAutoservice() {
       
        for (Car car : cars) {
            System.out.println("Car name: " + car.getName());
            System.out.println("Car color: " + car.getColor());
            System.out.println("Car speed: " + Float.toString(car.getSpeed()));
            System.out.println("Car sale price: " + Float.toString(car.getSalePrice()));
            System.out.println("Car rent price: " + Float.toString(car.getRentPrice()));            
            System.out.println("************");
        }
    }
    
    
    
}
