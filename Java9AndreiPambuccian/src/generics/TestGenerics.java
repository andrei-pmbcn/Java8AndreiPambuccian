/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author andrei
 */
public class TestGenerics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a box for integers
        GenericBox<Integer> boxForInteger = new GenericBox<Integer>();
        Integer value = new Integer(5);
        boxForInteger.setContent(value);
        System.out.println(boxForInteger.getContent());

        GenericBox<String> boxForString = new GenericBox<String>(); 
        String message = "Hello Java 9 colleagues";
        boxForString.setContent(message);
        System.out.println(boxForString.getContent());        
        
        GenericBox<Viezure> boxForViezure = new GenericBox<Viezure>();
        Viezure viezurelePrim = new Viezure();
        boxForViezure.setContent(viezurelePrim);
        System.out.println(boxForViezure.getContent().getNumarPicioareViezure());
        
    }
    

}
