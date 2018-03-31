/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstpackage1;

/**
 *
 * @author andrei
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        calc();
    }
    
    static void calc() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        System.out.println("Please introduce your first number:");        
        int x;
        try {
            x = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid number.");
            return;
        }

        System.out.println("Please introduce operator (+ - / *):");
        String sop = sc.next();
        String[] operators = {"+", "-", "/", "*"};
        if (!java.util.Arrays.asList(operators).contains(sop)) {
            System.out.println("Invalid operator.");
            return;
        }
        
        int y;
        System.out.println("Please introduce your second number:");        
        try {
            y = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid number.");
            return;
        }
        
        System.out.println("Please introduce the = sign:");
        String seq = sc.next();
        if (!"=".equals(seq)) {
            System.out.println("Invalid input.");
            return;
        }
        
        int res;
        
        switch (sop) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            default:
                res = 0;
                break;
        }
        
        System.out.print("Result: ");
        System.out.print(res);   
    }
}
