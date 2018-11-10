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
public class Dreptunghi extends Patrulater {
    public static final String DREPTUNGHI = " and four right angles";
    public static final String DREPTUNGHI_BEGIN = "Rectangle: ";

    public String getDefinition() {
        String definition = DREPTUNGHI_BEGIN
                + super.getDefinition().substring(15, 40)
                + "straight "
                + super.getDefinition().substring(40, super.getDefinition().length());
        definition += DREPTUNGHI;
        return definition;
    }    
}
