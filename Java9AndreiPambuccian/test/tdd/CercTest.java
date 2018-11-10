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
public class CercTest {
    
    public CercTest() {
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

    @Test
    public void testGetDefinition() {
        // TODO review the generated test code and remove the default call to fail.
        String testString = "Circle: a plane figure "
                + "whose boundary (the circumference) consists of points "
                + "equidistant from a fixed point (the center)";
        Cerc cerc = new Cerc();

        assertEquals(testString, cerc.getDefinition());
        
    }
    
}
