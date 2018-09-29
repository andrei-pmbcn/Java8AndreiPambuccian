/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

import java.util.Scanner;

/**
 *
 * @author andrei
 */
public abstract class BaseCalculator {
    protected double result;
        
    public double calculate() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("please introduce your first number.");
        int x = sc.nextInt();

        System.out.println("please introduce the operator.");
        String operator = sc.next();

        System.out.println("please introduce your second number.");
        int y = sc.nextInt();

        this.performOperation(x, y, operator);

        System.out.println("the result is: " + this.result);
        return this.result;
    }
    
    public abstract double performOperation(double x, double y, String operator) throws Exception;
    
    public double getResult() {
        return result;
    }
    
}
