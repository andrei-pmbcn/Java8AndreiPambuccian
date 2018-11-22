/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 *
 * @author andrei
 */
public class TestPhaser2 {

    static class ChunkedTask implements Runnable {
        private String name;
        private Phaser phaser;
        
        public ChunkedTask(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
            phaser.register();
        }        
        
        private void task1() {
            System.out.println("Thread " + name + " task 1 phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
        }
        
        private void task2() {
            System.out.println("Thread " + name + " task 2 phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
        }
        
        public void run() {
            while(phaser.getPhase() < 5) {
                task1();
                task2();
            }
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        ChunkedTask task1 = new ChunkedTask("1", phaser);
        ChunkedTask task2 = new ChunkedTask("2", phaser);
        exec.submit(task1);
        exec.submit(task2);
    }    
}
