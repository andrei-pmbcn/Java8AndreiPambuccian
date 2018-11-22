/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrent;
import java.util.LinkedList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author andrei
 */
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<LinkedList<Integer>> excng = new Exchanger<>();
        
        Runnable writer = () -> {
            int i = 0;
            LinkedList<Integer> writerArray = new LinkedList<>();
            while (true) {
                if (i < 3) {
                    writerArray.add(i);
                    i++;
                } else {
                    try {
                        writerArray = excng.exchange(writerArray);
                        i = 0;
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
        };
        Runnable reader = () -> {
            LinkedList<Integer> readerArray = new LinkedList<>();
            while(true) {
                try {
                    readerArray = excng.exchange(readerArray);
                } catch (InterruptedException ex) {
                    return;
                }
                while (readerArray.size() > 0) {
                    System.out.println(readerArray.pollFirst());
                }
            }
        };
        
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(writer);
        exec.submit(reader);
    }
}
