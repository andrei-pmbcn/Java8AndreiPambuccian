/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrei
 */
public class SayHello {
    public static void main(String[] args) {
        int numberOfParameters = Integer.parseInt(args[0]);
        try (FileWriter fw = new FileWriter("multithreading.txt")) {
            for (int param = 1; param <= numberOfParameters; param++) {
                fw.append("Hello " + args[param] + "\n");
                
                Map<String, String> env = System.getenv();
                String congrats = env.get("TEXT_CONGRATS");
                String hi = env.get("TEXT_HI");
                fw.append("ENVIRONMENT VARIABLE CONGRATS:" + congrats + "\n");
                fw.append("ENVIRONMENT VARIABLE HI:" + hi + "\n");
                fw.append("Hello (to arguments): " + args[param] + "\n");
                System.out.println("ENVIRONMENT VARIABLE CONGRATS: " + congrats);
                System.out.println("ENVIRONMENT VARIABLE HI: " + hi);
                System.out.println("MAIN METHOD ARGUMENT: " + args[param]);
            }
        } catch (IOException ex) {
            Logger.getLogger(SayHello.class.getName()).log(Level.SEVERE, "File could not be opened", ex);
        }
    }
}
