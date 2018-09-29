/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

/**
 *
 * @author andrei
 */
public class SimpleCalculator extends BaseCalculator {
    @Override
    public double performOperation(double x, double y, String operator) throws Exception {        
        switch (operator) {
            case "+":
                return this.add(x, y);
            case "-":
                return this.subtract(x, y);
            case "*":
                return this.multiply(x, y);
            case "/":
                return this.divide(x, y);
            default:
                throw new Exception("invalid operator");
        }
    }
    
    public double add(double x, double y) {
        this.result = x + y;
        return this.result;
    }
       
    public double subtract(double x, double y) {
        this.result = x - y;
        return this.result;
    }

    public double multiply(double x, double y) {
        this.result = x * y;
        return this.result;
    }
    
    public double divide(double x, double y) {
        this.result = x / y;
        return this.result;
    }
}
