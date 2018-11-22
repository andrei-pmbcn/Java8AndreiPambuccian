/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 *
 * @author andrei
 */
public class TestPhaser {
    static class ProducerTask<T extends Queue<E>, E> implements Runnable {
        private Phaser phaser;
        private T data;
        private E message;
        
        public ProducerTask(Phaser phaser, T data, E message) {
            this.phaser = phaser;
            this.data = data;
            this.message = message;
        }
        
        public void run() {
                while(true) {
                    int phase = phaser.getPhase();
                    if (phase % 2 == 0) {
                        data.add(message);
                        System.out.println((String) message + " arrived and awaiting, phase " + phase);
                        phaser.arriveAndAwaitAdvance();
                    } else {
                        System.out.println((String) message + " awaiting, phase " + phase);
                        phaser.awaitAdvance(phase);
                    }
                }
        }
    }
    
    static class ConsumerTask<T extends Queue<E>, E> implements Runnable {
        private Phaser phaser;
        private T data;
        
        public ConsumerTask(Phaser phaser, T data) {
            this.phaser = phaser;
            this.data = data;
        }
        
        public void run() {
            while (true) {
                int phase = phaser.getPhase();
                if (phase % 2 == 1) {
                    for (E message : data) {
                        System.out.println(message.toString());
                    }
                    System.out.println("consumer arrived and awaiting, phase " + phase);
                    phaser.arriveAndAwaitAdvance();
                } else {
                    System.out.println("consumer awaiting, phase " + phase);
                    phaser.awaitAdvance(phase);
                }
            }
        }
    }

    static class ClearingPhaser<T extends Queue> extends Phaser {
        private T data;
        private int nProducers;
        private int nConsumers;
        
        public ClearingPhaser(int i, T data) {
            super();
            this.bulkRegister(nProducers);
            this.data = data;
        }

        /*
        @Override
        public boolean onAdvance(int phase, int registeredParties) {
            if (phase % 2 == 1) {
                data.clear();
            }
            return true;
        }
        */
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> messages = new LinkedList<>();
        ClearingPhaser<LinkedList<String>> phaser = new ClearingPhaser<>(2, messages);
        ExecutorService exec = Executors.newFixedThreadPool(4);
        exec.submit(new ProducerTask<>(phaser, messages, "producer1"));
        exec.submit(new ProducerTask<>(phaser, messages, "producer2"));
        exec.submit(new ConsumerTask<>(phaser, messages));
        exec.submit(new ConsumerTask<>(phaser, messages));
    }
    
}
