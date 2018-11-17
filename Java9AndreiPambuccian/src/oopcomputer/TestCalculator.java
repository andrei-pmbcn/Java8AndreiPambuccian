/*
 * Testing calculator
 */
package oopcomputer;

import java.util.Scanner;

/**
 *
 * @author gheor
 */
public class TestCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creaza un calculator
        Carcasa calculator = new Carcasa();
        // Apasam butoane pana apare un operator
        calculator.getButon('1').apasa();
        calculator.getButon('2').apasa();
        calculator.getButon('3').apasa();
        calculator.getButon('+').apasa();   
        calculator.getButon('3').apasa();
        calculator.getButon('2').apasa();
        calculator.getButon('1').apasa();
        // Apasam butoane pana apare =
        calculator.getButon('=').apasa();
        // afisam rezultatul
        calculator.getEcran().printAfisaj();
    }
    
}
