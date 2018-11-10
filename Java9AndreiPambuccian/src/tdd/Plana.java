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
public class Plana extends FiguraGeometrica {
    public static final String PLANA = " plane";
    
    public String getDefinition() {
        String definition = super.O + PLANA + super.FIGURA; // 15
        return definition;
    }
}
