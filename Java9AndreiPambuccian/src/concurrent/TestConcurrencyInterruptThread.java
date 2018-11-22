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
public class TestConcurrencyInterruptThread extends Thread {
    private String name;
    private int state;
    private Thread target;
    
    public TestConcurrencyInterruptThread(String name, int state, Thread target) {
        this.name = name;
        this.state = state;
        this.target = target;        
    }
        
    public void run() {
        System.out.println("Running interrupt thread " + name
                + " with state " + state
                + " on target " + target );
        try {
            Thread.sleep(2000);
            //target.call();
            //Thread.sleep(2000);
            //target.call();
            //Thread.sleep(2000);
            target.interrupt();
        } catch (InterruptedException ex) {
            return;
        } catch (Exception ex) {
            return;
        }
    }   
}
