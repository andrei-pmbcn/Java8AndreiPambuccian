/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import concurrent.TestConcurrencyLoopThread;

/**
 *
 * @author andrei
 */
public class TestConcurrencyMutateThread extends Thread {
    private String name = "";
    private int state = 0;
    private TestConcurrencyLoopThread target;
    
    public TestConcurrencyMutateThread(String name, int state, TestConcurrencyLoopThread target) {
        this.name = name;
        this.state = state;
        this.target = target;
    }
        
    public void run() {
        try {
            while(true) {
                Thread.sleep(500);
                synchronized(target) {
                    target.setInternalState(target.getInternalState() + state);
                }
            }
        } catch (InterruptedException ex) {
            return;
        } 
    }
}