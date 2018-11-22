/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 *
 * @author andrei
 */
public class TestExecutor {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        
        LinkedList<CountTask> taskList = new LinkedList<>();
        for (int i = 0; i < 1000; i += 100) {
            taskList.add(new CountTask(i));
        }
        
        List<Future<Integer>> futureList = null;
        try {
            futureList = exec.invokeAll(taskList);
        } finally {
            exec.shutdown();
        }
        
        for (Future<Integer> f : futureList) {
            try { System.out.println(f.get()); } catch (ExecutionException ex) { /*...*/ }
        }
        
        /*
        for (int i = 0; i < 8; i++) {
            exec.submit(()->{
                System.out.println("Thread " + Thread.currentThread().getId());
            });
        }
        exec.shutdown();
        */
    }
}
