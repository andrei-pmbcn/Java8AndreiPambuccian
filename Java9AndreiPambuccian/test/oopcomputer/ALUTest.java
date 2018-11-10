/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopcomputer;

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
public class ALUTest {
    Carcasa carcasa;
    ALU instance;
    
    public ALUTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.carcasa = new Carcasa();
        this.instance = carcasa.getAlu();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOperator method, of class ALU.
     */
    @Test
    public void testGetOperator() {
        System.out.println("getOperator");
        Character expResult = '+';
        instance.setOperator('+');
        Character result = instance.getOperator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOperator method, of class ALU.
     */
    @Test
    public void testSetOperator() {
        System.out.println("setOperator");
        Character operator = '+';
        instance.setOperator(operator);
        assertEquals(instance.getOperator(), operator);
    }

    @Test(expected = RuntimeException.class)
    public void testSetOperatorThrows() {
        System.out.println("setOperator");
        Character operator = 'z';
        instance.setOperator(operator);
    }
    
    /**
     * Test of getOperandUnu method, of class ALU.
     */
    @Test
    public void testGetOperandUnu() {
        System.out.println("getOperandUnu");
        Integer expResult = 5;
        instance.setOperandUnu(5);
        Integer result = instance.getOperandUnu();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOperandUnu method, of class ALU.
     */
    @Test
    public void testSetOperandUnu() {
        System.out.println("setOperandUnu");
        Integer operandUnu = 5;
        instance.setOperandUnu(operandUnu);
        assertEquals(instance.getOperandUnu(), operandUnu);
    }

    /**
     * Test of setOperandUnu method, of class ALU.
     */
    @Test
    public void testInsertInOperandUnu() {
        System.out.println("includeInOperandUnu");
        instance.includeInOperandUnu('1');
        assertEquals(instance.getOperandUnu(), new Integer(1));
        
        instance.includeInOperandUnu('2');
        assertEquals(instance.getOperandUnu(), new Integer(12));
    }

    /**
     * Test of getOperandDoi method, of class ALU.
     */
    @Test
    public void testGetOperandDoi() {
        System.out.println("getOperandDoi");
        Integer expResult = 3;
        instance.setOperandDoi(3);
        Integer result = instance.getOperandDoi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOperandDoi method, of class ALU.
     */
    @Test
    public void testSetOperandDoi() {
        System.out.println("setOperandDoi");
        Integer operandDoi = 4;
        instance.setOperandDoi(operandDoi);
        assertEquals(instance.getOperandDoi(), operandDoi);
    }

    /**
     * Test of setOperandDoi method, of class ALU.
     */
    @Test
    public void testIncludeInOperandDoi() {
        System.out.println("includeInOperandDoi");
        instance.includeInOperandDoi('1');
        assertEquals(instance.getOperandDoi(), new Integer(1));

        instance.includeInOperandDoi('2');
        assertEquals(instance.getOperandDoi(), new Integer (12));
    }

    /**
     * Test of getRezultat method, of class ALU.
     */
    @Test
    public void testGetRezultat() {
        System.out.println("getRezultat");
        Integer expResult = 3;
        instance.setRezultat(3);
        Integer result = instance.getRezultat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRezultat method, of class ALU.
     */
    @Test
    public void testSetRezultat() {
        System.out.println("setRezultat");
        Integer rezultat = 10;
        instance.setRezultat(rezultat);
        assertEquals(instance.getRezultat(), rezultat);
    }

    /**
     * Test of calculeaza method, of class ALU.
     */
    @Test
    public void testCalculeaza() {
        System.out.println("calculeaza");
        instance.setOperandUnu(1);
        instance.setOperator('+');
        instance.setOperandDoi(2);
        instance.calculeaza();
        assertEquals(instance.getRezultat(), new Integer(3));
    }
    
}
