/*
 * Carcasa calculatorului de birou
 */
package oopcomputer;

import java.util.HashMap;

/**
 *
 * @author gheor
 */
public class Carcasa {
    
    private Ecran ecran = new Ecran(this);
    private HashMap<Character, Buton> butoane;
    private ALU alu = new ALU(this);      

    public Carcasa() {
        this.butoane = new HashMap();
        
        for (Character operand : this.alu.CIFRE) {
            this.butoane.put(operand, new Buton(operand, this, true));
        }
        
        for (Character operator : this.alu.OPERATORI) {
            this.butoane.put(operator, new Buton(operator, this, false));
        }

        this.butoane.put('=', new Buton('=', this, false));        
    }
    
    public Ecran getEcran() {
        return this.ecran;
    }

    public void setEcran(Ecran ecran) {
        this.ecran = ecran;
    }

    public HashMap<Character, Buton> getButoane() {
        return this.butoane;
    }
   
    public void setButoane(HashMap<Character, Buton> butoane) {
        this.butoane = butoane;
    }

    public Buton getButon(Character simbol) {
        return this.butoane.get(simbol);
    }
        
    public ALU getAlu() {
        return this.alu;
    }

    public void setAlu(ALU alu) {
        this.alu = alu;
    }
}
