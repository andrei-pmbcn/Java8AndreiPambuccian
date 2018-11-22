/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author andrei
 */
public class TestSemaphore2 {

    public static class SemaphoredData<T> {
        Semaphore semaphore;
        T data;

        public SemaphoredData(int limit, T data) {
            this.semaphore = new Semaphore(limit);
            this.data = data;
        } 

        public T get() {
            try {
                semaphore.acquire();
                return data;
            } catch (InterruptedException ex) {
                return null;
            }
        }
        
        public void release() {
            semaphore.release();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SemaphoredData<ArrayList> semaphoredArray = new SemaphoredData<>(10, new ArrayList());
                
        Runnable appendTask = () -> {
            semaphoredArray.get().add("test");
            semaphoredArray.release();
        };
        
        ExecutorService exec = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 100; i++) {
            exec.submit(appendTask);
        }
    }   
}
