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
public class Contor {
    private volatile int valoare = 0;

    /**
     * Metoda incrementeaza valoarea
     */
    public synchronized void incrementeaza() {
        valoare++;
    }
    
    /**
     * Metoda decrementeaza valoarea
     */
    public synchronized void decrementeaza() {
        valoare--;
    }

    /**
     * Metoda returneaza valoarea
     * @return valoare
     */
    public synchronized int getValoare() {
        return valoare;
    }
}
