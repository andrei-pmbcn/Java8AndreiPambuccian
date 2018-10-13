/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsandnumbers;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author andrei
 */
public class TestFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long n = 461012;
        System.out.format("%d%n", n);      //  
        System.out.format("%08d%n", n);    //  
        System.out.format("%+8d%n", n);    //  
        System.out.format("%,8d%n", n);    // 
        System.out.format("%+,8d%n%n", n); //  
        System.out.format("%+,010d%n%n", 123456);
        
        double pi = Math.PI;
        System.out.format("%f%n", pi);       // 
        System.out.format("%.3f%n", pi);     // 
        System.out.format("%10.3f%n", pi);   // 
        System.out.format("%10.3f%n", pi);  //
        System.out.format(Locale.FRANCE,"%10.4f%n%n", pi); // 

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // 
        System.out.format("%tl:%tM %tp%n", c, c, c);  // 
        System.out.format("%tD%n", c);    // 

    }
    
}
