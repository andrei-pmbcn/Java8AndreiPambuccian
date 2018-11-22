/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author andrei
 */

public class TestCountDownLatch {
    static class LatchTask implements Runnable, Callable<Integer> {
        Integer i;
        CountDownLatch latch;
        
        public LatchTask(int i, CountDownLatch latch) {
            this.i = new Integer(i);
            this.latch = latch;
        }
        
        public void run() {
            while (latch.getCount() > 0) {
                i++;
                latch.countDown();
            }
        }
        
        public Integer call() {
            return i;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        LatchTask latchTask = new LatchTask(0, latch);
        Runnable waitingTask = () -> {
            try {
                latch.await();
            } catch (InterruptedException ex) {
                //...
            }
            System.out.println("waitingTask done");
        };
        ExecutorService exec = Executors.newFixedThreadPool(2);

        exec.submit((Runnable) latchTask);
        exec.submit(waitingTask);
        while(latch.getCount() > 0) {};
        System.out.println(latchTask.call());
    }   
}
