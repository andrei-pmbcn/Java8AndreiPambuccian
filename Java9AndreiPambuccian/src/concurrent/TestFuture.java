/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author andrei
 */
public class TestFuture {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService execCounter = Executors.newSingleThreadExecutor();
        Callable<Long> computeTask = new Callable<Long>() {
            public Long call() {
                Long val = (long) 1;
                for (int i = 2; i < 10; i++) {
                    val *= i;
                    System.out.println(val);
                }
                return val;
            }
        };
        Future future = execCounter.submit(computeTask);
        Runnable checkTask = new Runnable() {
            public void run() {
                try {
                    while (!future.isDone()) {
                        Thread.sleep(100);
                    }
                    System.out.println("result: " + future.get());
                } catch (Exception ex) {
                    //...
                }
            }
        };                                
        ExecutorService execChecker = Executors.newSingleThreadExecutor();
        execChecker.submit(checkTask);
    }    
}
