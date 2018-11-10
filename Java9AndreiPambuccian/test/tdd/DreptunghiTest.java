/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

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
public class DreptunghiTest {
    
    public DreptunghiTest() {
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
     * Test of getDefinition method, of class Dreptunghi.
     */
    @Test
    public void testGetDefinition() {
        System.out.println("getDefinition");
        Dreptunghi instance = new Dreptunghi();
        String expResult = "Rectangle: a plane figure with four straight sides "
                + "and four right angles";
        String result = instance.getDefinition();
        assertEquals(expResult, result);
    }
    
}
