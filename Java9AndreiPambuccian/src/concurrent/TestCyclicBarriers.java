/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author andrei
 */


public class TestCyclicBarriers {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        List<Integer> array = Collections.synchronizedList(new ArrayList<Integer>());
        Runnable barrierRunnable = () -> { array.add(3); };
        CyclicBarrier barrier = new CyclicBarrier(2, barrierRunnable);

        Runnable task = () -> {
            while(true) {
                array.add(1);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ex) {
                    //...
                }    
            } 
        };

        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(task);
        exec.submit(task);
        while(array.size() < 6) {};
        exec.shutdown();
        System.out.println(array.toString());
    }   
}

