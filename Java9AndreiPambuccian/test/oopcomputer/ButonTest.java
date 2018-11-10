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
public class ButonTest {
    
    public ButonTest() {
    }
    
    Carcasa carcasa;
    Buton instance;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        carcasa = new Carcasa();
        instance = new Buton('1', carcasa, true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of apasa method, of class Buton.
     */
    @Test
    public void testApasa() {
        System.out.println("apasa");
        Character result = carcasa.getButon('1').apasa();
        String display = carcasa.getEcran().getAfisaj();
        assertEquals(result, new Character('1'));
        
        assertEquals(display, "1");

        carcasa.getButon('2').apasa();
        display = carcasa.getEcran().getAfisaj();
        
        assertEquals(carcasa.getAlu().getOperandUnu(), new Integer(12));
        assertEquals(carcasa.getAlu().getOperandDoi(), null);
        assertEquals(display, "12");
        
        carcasa.getButon('+').apasa();
        display = carcasa.getEcran().getAfisaj();

        assertEquals(display, "12 +");

        carcasa.getButon('3').apasa();
        display = carcasa.getEcran().getAfisaj();

        assertEquals(display, "12 + 3");

        carcasa.getButon('4').apasa();
        display = carcasa.getEcran().getAfisaj();
        
        assertEquals(carcasa.getAlu().getOperandUnu(), new Integer(12));
        assertEquals(carcasa.getAlu().getOperandDoi(), new Integer(34));
        assertEquals(display, "12 + 34");

        carcasa.getButon('=').apasa();
        display = carcasa.getEcran().getAfisaj();
        
        assertEquals(display, "Rezultat: 46");
    }

    /**
     * Test of getSimbol method, of class Buton.
     */
    @Test
    public void testGetSimbol() {
        System.out.println("getSimbol");
        Character expResult = '1';
        Character result = instance.getSimbol();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSimbol method, of class Buton.
     */
    @Test
    public void testSetSimbol() {
        System.out.println("setSimbol");
        Character noulSimbol = '2';
        instance.setSimbol(noulSimbol);
        assertEquals(instance.getSimbol(), new Character('2'));
    }
    
    /**
     * Test of getCarcasa method, of class Buton.
     */
    @Test
    public void testGetCarcasa() {
        System.out.println("getCarcasa");
        Carcasa expResult = this.carcasa;
        Carcasa result = instance.getCarcasa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCarcasa method, of class Buton.
     */
    @Test
    public void testSetCarcasa() {
        System.out.println("setCarcasa");
        Carcasa nouaCarcasa = new Carcasa();
        instance.setCarcasa(nouaCarcasa);
        assertEquals(instance.getCarcasa(), nouaCarcasa);
    }
    
}
