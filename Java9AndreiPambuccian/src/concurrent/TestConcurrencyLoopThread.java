/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.concurrent.Callable;

/**
 *
 * @author andrei
 */
public class TestConcurrencyLoopThread extends Thread implements Callable<Integer> {
    private String name = "";
    private int state = 0;
    
    public TestConcurrencyLoopThread(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public void setInternalState(int value) {
        state = value;
    }
    
    public int getInternalState() {
        return state;
    }
    
    public void run() {
        System.out.println("Running thread " + name + " with state " + state);
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("ping " + state);
            } catch (InterruptedException ex) {
                System.out.println("Thread " + name
                        + " interrupted with state " + state);
                return;
            }
        }
    }
    
    public Integer call() {
        System.out.println("called");
        return 1;
    }
}
