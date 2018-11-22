/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author andrei
 */
public class RunningThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread tha = new HelloAllThread();
        tha.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Prioritatea thread-ului HelloAll: "
                + tha.getPriority());
        Thread thw = new HelloWorldThread();
        thw.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Prioritatea thread-ului HelloWorld: "
                + thw.getPriority());
        tha.start();
        thw.start();
    }
    
}
