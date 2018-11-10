/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import static tdd.Dreptunghi.DREPTUNGHI;

/**
 *
 * @author andrei
 */
public class Patrat extends Dreptunghi {
    public static final String PATRAT_BEGIN = "Square: ";
    public static final String PATRAT = "equal";
        
        public String getDefinition() {
            String definition = PATRAT_BEGIN
                + super.getDefinition().substring(11, 36)
                + PATRAT
                + super.getDefinition().substring(44,
                    super.getDefinition().length());
        return definition;
    }    
}
