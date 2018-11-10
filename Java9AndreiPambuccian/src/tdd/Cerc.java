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
public class Cerc extends Plana {
    public static final String CIRCLE_BEGIN = "Circle: ";
    public static final String CIRCLE = "whose boundary (the circumference) "
            + "consists of points equidistant from a fixed point (the center)";
    public String getDefinition() {
        String definition = CIRCLE_BEGIN + super.getDefinition() + CIRCLE;
        return definition;
        
    }
}
