/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.Random;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

import java.lang.reflect.Array;

/**
 *
 * @author andrei
 */
public class TestSemaphore {
    static class Ticker extends Thread implements Callable<Integer> {
        private Integer ticks = 0;
        public void run() {
            try {
                while (ticks < 1000) {
                    Thread.sleep(10); ticks += 1; 
                }
            } catch (InterruptedException ex) {
            }         
        } 
        public Integer call() {
            return ticks;
        }
    }

    static class Prod extends Thread {
        String store;
        SemaphoredQueue<String> queue;
        Random timer = new Random();
        int ticks = 0;
        
        public Prod(String store, SemaphoredQueue<String> queue) {
            this.store = store;
            this.queue = queue;
        }
        
        public void run() {
            try {
                while(true) {
                    System.out.println(store + " adding to queue");
                    queue.getByProducer().add(store + "-" + String.valueOf(ticks));
                    queue.doneProducer();
                    ticks += 1;
                    Thread.sleep(200 - timer.nextInt(20));
                }
            } catch (InterruptedException ex) {}
        }
    }
    
    static class Cons extends Thread {
        SemaphoredQueue<String> queue;
        Random timer = new Random();
        
        public Cons(SemaphoredQueue<String> queue) {
            this.queue = queue;
        }
        
        public void run() {
            try {
                while(true) {
                    System.out.println("consumer polling queue");
                    String s = queue.getByConsumer().poll();
                    queue.doneConsumer();
                    System.out.println(s);
                    Thread.sleep(200 - timer.nextInt(20));
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    public static class SemaphoredQueue<T> {
        Semaphore producerSemaphore;
        Semaphore consumerSemaphore;
        Queue<T> queue;

        public SemaphoredQueue (
                int producerLimit, int consumerLimit, Queue<T> queue) {
            this.producerSemaphore = new Semaphore(producerLimit);
            this.consumerSemaphore = new Semaphore(consumerLimit);
            this.queue = queue;
        }
        
        public Queue<T> getByProducer() {
            try {
                producerSemaphore.acquire();
                return queue;
            } catch (InterruptedException ex) {
                return null;
            }
        }

        public Queue<T> getByConsumer() {
            try {
                consumerSemaphore.acquire();
                return queue;
            } catch (InterruptedException ex) {
                return null;
            }
        }
        
        public void doneProducer() {
            producerSemaphore.release();
        }
        
        public void doneConsumer() {
            consumerSemaphore.release();
        }
    }
    
    public static void main(String[] args) {
        /*
        Ticker t1 = new Ticker();
        t1.start();

        Runnable caller = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                } finally {
                    System.out.println(t1.call());
                }
            }
        };
        caller.run();
        */
        

        SemaphoredQueue messages = new SemaphoredQueue(
                1, 1, new ConcurrentLinkedQueue<String>());
        
        Prod p1 = new Prod("producer1", messages);
        Prod p2 = new Prod("producer2", messages);
        Prod p3 = new Prod("producer3", messages);
        Cons c = new Cons(messages);
        p1.start(); p2.start(); p3.start(); c.start();
    }
    

    
}
