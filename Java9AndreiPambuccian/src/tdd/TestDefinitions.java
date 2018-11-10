/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.LinkedList;

/**
 *
 * @author andrei
 */
public class TestDefinitions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dreptunghi d1 = new Dreptunghi();
        Dreptunghi d2 = new Dreptunghi();
        Cerc c = new Cerc();
        Patrat p = new Patrat();
        Triunghi t1 = new Triunghi();
        Triunghi t2 = new Triunghi();
        
        LinkedList<FiguraGeometrica> listaDeFiguri = new LinkedList<>();
        listaDeFiguri.add(d1);
        listaDeFiguri.add(d2);
        listaDeFiguri.add(c);
        listaDeFiguri.add(p);
        listaDeFiguri.add(t1);
        listaDeFiguri.add(t2);
        
        listaDeFiguri.forEach((t) -> System.out.println(t.getDefinition()));
    }
    
}
