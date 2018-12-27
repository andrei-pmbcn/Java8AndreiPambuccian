/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
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
public class ComplexCalculatorTest {
    
    public ComplexCalculatorTest() {
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
     * Test of calculate method, of class ComplexCalculator.
     */
    @Test
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        ComplexCalculator instance = new ComplexCalculator();
        double expResult = 6.0;
        String s = "2.0\n*\n3.0";
        ByteArrayInputStream ss = new ByteArrayInputStream(s.getBytes());
        System.setIn(ss);
        double result = instance.calculate();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of performOperation method, of class ComplexCalculator.
     */
    @Test
    public void testPerformOperation() throws Exception {
        System.out.println("performOperation");
        ComplexCalculator instance = new ComplexCalculator();
        instance.add(1.0, 1.0);        
        double x = 1.0;
        String operator = "+";
        double expResult = 3.0;
        double result = instance.performOperation(x, operator);
        assertEquals(expResult, result, 0.00001);
        
        x = 1.0;
        operator = "-";
        expResult = 2.0;
        result = instance.performOperation(x, operator);
        assertEquals(expResult, result, 0.00001);
        
        x = 2.0;
        operator = "*";
        expResult = 4.0;
        result = instance.performOperation(x, operator);
        assertEquals(expResult, result, 0.00001);

        x = 2.0;
        operator = "/";
        expResult = 2.0;
        result = instance.performOperation(x, operator);
        assertEquals(expResult, result, 0.00001);
        
    }

    /**
     * Test of add method, of class ComplexCalculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double x = 1.0;
        ComplexCalculator instance = new ComplexCalculator();
        instance.add(1.0, 2.0);
        double expResult = 4.0;
        double result = instance.add(x);
        assertEquals(expResult, result, 0.00001);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of subtract method, of class ComplexCalculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        double x = 2.0;
        ComplexCalculator instance = new ComplexCalculator();
        instance.add(1.0, 2.0);
        double expResult = 1.0;
        double result = instance.subtract(x);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of multiply method, of class ComplexCalculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double x = 2.0;
        ComplexCalculator instance = new ComplexCalculator();
        instance.add(1.0, 1.0);
        double expResult = 4.0;
        double result = instance.multiply(x);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of divide method, of class ComplexCalculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double x = 2.0;
        ComplexCalculator instance = new ComplexCalculator();
        instance.add(2.0, 2.0);
        double expResult = 2.0;
        double result = instance.divide(x);
        assertEquals(expResult, result, 0.00001);
    }
    
}
