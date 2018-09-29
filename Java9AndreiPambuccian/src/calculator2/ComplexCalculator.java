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
public class ComplexCalculator extends SimpleCalculator {
    @Override
    public double calculate() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("please introduce your first number.");
        int x = sc.nextInt();

        System.out.println("please introduce the operator.");
        String operator = sc.next();

        try {
            System.out.println("please introduce your second number.");
            int y = sc.nextInt();
            this.performOperation(x, y, operator);
        } catch (Exception e) {
            this.performOperation(x, operator);
        }

        System.out.println("the result is: " + this.result);
        return this.result;
    }

    public double performOperation(double x, String operator) throws Exception {
        switch (operator) {
            case "+":
                return this.add(x);
            case "-":
                return this.subtract(x);
            case "*":
                return this.multiply(x);
            case "/":
                return this.divide(x);
            default:
                throw new Exception("invalid operator");
        }            

    }

    public double add(double x) {
        this.result += x;
        return this.result;
    }
    
    public double subtract(double x) {
        this.result -= x;
        return this.result;
    }
    
    public double multiply(double x) {
        this.result *= x;
        return this.result;
    }
    
    public double divide(double x) {
        this.result /= x;
        return this.result;
    }
}
