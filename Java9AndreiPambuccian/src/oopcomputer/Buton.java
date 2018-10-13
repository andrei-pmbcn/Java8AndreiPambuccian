/*
 * Clasa buton din care vom creea butoanele
 */
package oopcomputer;

/**
 *
 * @author gheor
 */
public class Buton {
    
    private Character simbol;
    
    public Buton(Character noulSimbol){
        simbol = noulSimbol;
    }
    public Character apasa(){
        return simbol;
    }
}
