/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopcomputer;

import java.util.HashMap;
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
public class CarcasaTest {
    
    Carcasa instance;
    
    public CarcasaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Carcasa();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEcran method, of class Carcasa.
     */
    @Test
    public void testSetEcran() {
        System.out.println("setEcran");
        Ecran ecran = new Ecran(instance);
        instance.setEcran(ecran);
        assertEquals(instance.getEcran(), ecran);
    }    
    
    /**
     * Test of setButoane method, of class Carcasa.
     */
    @Test
    public void testSetButoane() {
        System.out.println("setButoane");
        Carcasa instance = new Carcasa();
        HashMap<Character, Buton> expResult = new HashMap<>();
        expResult.put('1', new Buton('1', instance, true));
        instance.setButoane(expResult);
        HashMap<Character, Buton> result = instance.getButoane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlu method, of class Carcasa.
     */
    @Test
    public void testSetAlu() {
        System.out.println("setAlu");
        ALU alu = new ALU(instance);
        Carcasa instance = new Carcasa();
        instance.setAlu(alu);
        assertEquals(instance.getAlu(), alu);
    }



    
}
