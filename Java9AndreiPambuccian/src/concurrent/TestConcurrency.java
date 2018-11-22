/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

/**
 *
 * @author andrei
 */
public class TestConcurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestConcurrencyLoopThread tl = new TestConcurrencyLoopThread("tl", 1);
        tl.setPriority(10);
        Thread ti = new TestConcurrencyInterruptThread("ti", 2, tl);
        ti.setPriority(1);
        
        //Thread tm1 = new TestConcurrencyMutateThread("tm1", 1, tl);
        //Thread tm2 = new TestConcurrencyMutateThread("tm2", -1, tl);

        tl.start();
        ti.start();
        //tm1.start();
        //tm2.start();


    }
    
}
