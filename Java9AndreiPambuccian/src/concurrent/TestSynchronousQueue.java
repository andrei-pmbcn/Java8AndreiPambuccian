/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author andrei
 */
public class TestSynchronousQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Runnable producer = () -> {
            int i = 0;
            try {
                while (true) {
                    queue.put("message " + i);
                    i++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) { /*...*/ }
        };
        
        Runnable consumer = () -> {
            try {
                while (true) {
                    System.out.println(queue.take());
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) { /*...*/ }
        };
        
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(producer);
        exec.submit(consumer);
    }
}
