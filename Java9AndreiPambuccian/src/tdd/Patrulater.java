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
public class Patrulater extends Plana {
    public static final String PATRULATER_BEGIN = "Quadrilateral: ";
    public static final String PATRULATER = "with four sides";
    
    public String getDefinition() {
        String definition = PATRULATER_BEGIN
                + super.getDefinition() + PATRULATER;
        return definition;
    }    
}
