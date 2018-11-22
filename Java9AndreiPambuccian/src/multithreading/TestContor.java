/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author andrei
 */
public class TestContor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contor contor = new Contor();
        CyclicBarrier cb = new CyclicBarrier(2);
        Adunare adunare = new Adunare(contor, cb);
        Scadere scadere = new Scadere(contor, cb);
        
        adunare.start();
        scadere.start();
        System.out.println(contor.getValoare());
    }
}
