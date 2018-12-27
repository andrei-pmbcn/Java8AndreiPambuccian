/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

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
public class SimpleCalculatorTest {
    
    public SimpleCalculatorTest() {
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
     * Test of performOperation method, of class SimpleCalculator.
     */
    @Test
    public void testPerformOperation() throws Exception {
        System.out.println("performOperation");
        double x = 1.0;
        double y = 2.0;
        String operator = "+";
        double expResult = 3.0;
        SimpleCalculator instance = new SimpleCalculator();
        double result = instance.performOperation(x, y, operator);
        assertEquals(expResult, result, 0.0);

        x = 2.0;
        y = 1.0;
        operator = "-";
        expResult = 1.0;
        result = instance.performOperation(x, y, operator);
        assertEquals(expResult, result, 0.0);

        x = 3.0;
        y = 2.0;
        operator = "*";
        expResult = 6.0;
        result = instance.performOperation(x, y, operator);
        assertEquals(expResult, result, 0.0);

        x = 4.0;
        y = 2.0;
        operator = "/";
        expResult = 2.0;
        result = instance.performOperation(x, y, operator);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of add method, of class SimpleCalculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double x = 3.0;
        double y = 2.0;
        SimpleCalculator instance = new SimpleCalculator();
        double expResult = 5.0;
        double result = instance.add(x, y);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of subtract method, of class SimpleCalculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        double x = 4.0;
        double y = 2.0;
        SimpleCalculator instance = new SimpleCalculator();
        double expResult = 2.0;
        double result = instance.subtract(x, y);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of multiply method, of class SimpleCalculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double x = 10.0;
        double y = 5.0;
        SimpleCalculator instance = new SimpleCalculator();
        double expResult = 50.0;
        double result = instance.multiply(x, y);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of divide method, of class SimpleCalculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double x = 20.0;
        double y = 4.0;
        SimpleCalculator instance = new SimpleCalculator();
        double expResult = 5.0;
        double result = instance.divide(x, y);
        assertEquals(expResult, result, 0.0);
    }
    
}
