/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrei
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aduna method, of class Calculator.
     */
    @Test
    public void testAduna() {
        System.out.println("aduna");
        int a = 1;
        int b = 2;
        Calculator instance = new Calculator();
        int expResult = 3;
        int result = instance.aduna(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of scade method, of class Calculator.
     */
    @Test
    public void testScade() {
        System.out.println("scade");
        int a = 3;
        int b = 1;
        Calculator instance = new Calculator();
        int expResult = 2;
        int result = instance.scade(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of inmulteste method, of class Calculator.
     */
    @Test
    public void testInmulteste() {
        System.out.println("inmulteste");
        int a = 5;
        int b = 3;
        Calculator instance = new Calculator();
        int expResult = 15;
        int result = instance.inmulteste(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of imparte method, of class Calculator.
     */
    @Test
    public void testImparte() {
        System.out.println("imparte");
        int a = 4;
        int b = 2;
        Calculator instance = new Calculator();
        int expResult = 2;
        int result = instance.imparte(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
