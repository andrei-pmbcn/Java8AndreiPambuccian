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
public class CountTask implements Runnable, Callable<Integer> {
    private Integer n;
    public CountTask(int n) { this.n = new Integer(n); };

    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                n += 1;
            }
        } catch (InterruptedException ex) {
            return;
        }
    }
    public Integer call() {
        return n;
    }
}
