/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

/**
 *
 * @author andrei
 */
public class Triunghi extends Plana {
    public static final String TRIUNGHI_BEGIN = "Triangle: ";
    public static final String TRIUNGHI = "with three sides";
    
    public String getDefinition() {
        return TRIUNGHI_BEGIN + super.getDefinition() + TRIUNGHI;
    }
}
