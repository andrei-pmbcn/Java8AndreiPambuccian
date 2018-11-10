/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrei
 */
public class OpenFile2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader("text.txt")); 
            System.out.println("C:\\Users\\gheor\\Desktop\\text.txt");
            try 
            { 
                String firstLine = r.readLine();
            }
            catch 
            (IOException e) {
                Logger.getLogger(OpenFile2.class.getName()).log(Level.INFO, null, e);
                System.out.println("Cannot read first line from text.txt: " 
                + e.getMessage()); 
            }
            finally 
            {
                try {
                    r.close();
                } catch (IOException ex) {
                    System.out.println("Exceptia a dat mesajul:" + ex.getMessage());
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException:" + ex.getMessage());
        }
    }
    
}
