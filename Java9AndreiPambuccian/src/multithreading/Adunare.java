/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Clasa aeste un thread paralel care va aduna o unitate la un obiect de tip contor
 * @author andrei
 */
public class Adunare extends Thread {
    private final Contor contor;
    private final CyclicBarrier cb;
    
    public Adunare(Contor contor, CyclicBarrier cb) {
        this.contor = contor;
        this.cb = cb;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            try {
                cb.await();
                contor.incrementeaza();
            } catch (InterruptedException ex) {
                cb.isBroken();
                return;
            } catch (BrokenBarrierException ex) {
                return;
            }
        }
    }
}
