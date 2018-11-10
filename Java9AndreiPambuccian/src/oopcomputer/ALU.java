/*
 * Aritmetical and Logical Unit
 */
package oopcomputer;

import java.util.Arrays;
import static java.util.Objects.isNull;

/**
 *
 * @author gheor
 */
public class ALU {
    
    private Integer operandUnu;
    private Integer operandDoi;
    private Character operator;
    private Integer rezultat;
    
    public final Character[] CIFRE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final Character[] OPERATORI = {'+', '-', '*', '/'};
    private final Carcasa carcasa;
    
    public ALU(Carcasa nouaCarcasa) {
        this.carcasa = nouaCarcasa;
    }
    
    public Character getOperator() {
        return this.operator;
    }

    public void setOperator(Character operator) { 
        if (Arrays.asList(OPERATORI).contains(operator)) {
            this.operator = operator;
        } else {
            throw new RuntimeException("Eroare: operator invalid");
        }
    }

    public Integer getOperandUnu() {
        return this.operandUnu;
    }

    public void setOperandUnu(Integer operandUnu) {
        this.operandUnu = operandUnu;
    }
    
    public void includeInOperandUnu(Character simbol) {
        if (isNull(operandUnu)) {
            this.operandUnu = Character.getNumericValue(simbol);
        } else {
            this.operandUnu = this.operandUnu * 10
                    + Character.getNumericValue(simbol);        
        }
    }

    public Integer getOperandDoi() {
        return this.operandDoi;
    }

    public void setOperandDoi(Integer operandDoi) {
        this.operandDoi = operandDoi;
    }

    public void includeInOperandDoi(Character simbol) {
        if (isNull(operandDoi)) {
            this.operandDoi = Character.getNumericValue(simbol);
        } else {
            this.operandDoi = this.operandDoi * 10
                    + Character.getNumericValue(simbol);
        }
    }
    
    public Integer getRezultat() {
        return this.rezultat;
    }

    public void setRezultat(Integer rezultat) {
        this.rezultat = rezultat;
    }

    
    public void calculeaza(){        
        switch (this.operator){
        
            case '+': 
                rezultat = operandUnu + operandDoi;
                break;
            case '-': 
                rezultat = operandUnu - operandDoi;
                break;
            case '*': 
                rezultat = operandUnu * operandDoi;
                break;
            case '/': 
                rezultat = operandUnu / operandDoi;
                break;
            default: 
                System.out.println("Operatorul este incorect. Folositi +, -, * sau /");
        }
        this.operandUnu = null;
        this.operandDoi = null;
        this.operator = null;
    }
}
