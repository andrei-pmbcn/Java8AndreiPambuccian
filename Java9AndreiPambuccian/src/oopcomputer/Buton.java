/*
 * Clasa buton din care vom creea butoanele
 */
package oopcomputer;

import java.util.Arrays;
import static java.util.Objects.isNull;

/**
 *
 * @author gheor
 */
public class Buton {
    
    private Character simbol;
    private Carcasa carcasa;
    private boolean isNumber;
    
    public Buton(Character noulSimbol, Carcasa nouaCarcasa, boolean isNumber){
        this.simbol = noulSimbol;
        this.carcasa = nouaCarcasa;
        this.isNumber = isNumber;
    }
    
    public Character getSimbol() {
        return this.simbol;        
    }
    
    public void setSimbol(Character noulSimbol) {
        this.simbol = noulSimbol;
        if (Arrays.asList(this.carcasa.getAlu().CIFRE).contains(this.simbol)) {
            this.isNumber = true;
        } else {
            this.isNumber = false;
        }
    }
        
    public Carcasa getCarcasa() {
        return this.carcasa;        
    }
    
    public void setCarcasa(Carcasa nouaCarcasa) {
        this.carcasa = nouaCarcasa;
    }
       
    public Character apasa(){
        ALU alu = this.carcasa.getAlu();
        System.out.println("a fost apasat: " + simbol);
        if (isNumber) {
            if (isNull(alu.getOperator())) {
                alu.includeInOperandUnu(simbol);
                this.carcasa.getEcran().setAfisaj(
                        alu.getOperandUnu().toString());
            } else {
                alu.includeInOperandDoi(simbol);
                this.carcasa.getEcran().setAfisaj(
                        alu.getOperandUnu().toString()
                        + " " + alu.getOperator().toString()
                        + " " + alu.getOperandDoi().toString());
            }
        } else if (simbol == '=') {
            alu.calculeaza();
            this.carcasa.getEcran().setAfisaj(
                    "Rezultat: " + alu.getRezultat());
        } else {
            alu.setOperator(simbol);
            this.carcasa.getEcran().setAfisaj(
                    alu.getOperandUnu().toString()
                    + " " + alu.getOperator().toString());
        }
        
        return simbol;
    }
}
