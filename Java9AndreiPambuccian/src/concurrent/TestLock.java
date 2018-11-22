/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author andrei
 */
public class TestLock {

    static class NonDeadlockThread extends Thread {
        private String reply;
        private final Lock lock = new ReentrantLock();
        
        public NonDeadlockThread(String reply) { this.reply = reply; }
        public Lock getLock() { return lock; }
        
        public boolean preAction(NonDeadlockThread other) {
           boolean ownLock = false;
           boolean otherLock = false;
           
           try {
               ownLock = lock.tryLock();
               otherLock = other.getLock().tryLock();
           } finally {
               if (! (ownLock && otherLock)) {
                   if (ownLock) {
                       lock.unlock();
                   } else if (otherLock) {
                       other.getLock().unlock();
                   }
                }
           }
           return ownLock && otherLock;
        }
        
        public void invoke(NonDeadlockThread other) {
            if (preAction(other)) {
                try {
                    other.respond();
                } finally {
                    lock.unlock();
                    other.lock.unlock();
                }
                
            }
        }
        
        public void respond() {
            System.out.println(reply);
        }
    }

    static class InvokeLoop implements Runnable {
        private NonDeadlockThread thread1;
        private NonDeadlockThread thread2;
        
        public InvokeLoop(NonDeadlockThread thread1, NonDeadlockThread thread2) {
            this.thread1 = thread1;
            this.thread2 = thread2;
        }
        
        public void run() {
            Random rand = new Random();
            while (true) {
                try {
                    Thread.sleep(rand.nextInt(10));
                } catch (InterruptedException e) {}
                thread1.invoke(thread2);
            }
        }        
    }
    
    public static void main(String[] args) {
        NonDeadlockThread thread1 = new NonDeadlockThread("test1");
        NonDeadlockThread thread2 = new NonDeadlockThread("test2");
        
        new Thread(new InvokeLoop(thread1, thread2)).start();
        new Thread(new InvokeLoop(thread2, thread1)).start();
    }
}