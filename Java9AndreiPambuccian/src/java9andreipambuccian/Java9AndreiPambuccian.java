/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java9andreipambuccian;



/**
 *
 * @author andrei
 */
public class Java9AndreiPambuccian {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Able was I ere I saw Elba.");
        System.out.println(sb.capacity());
        System.out.println("***");
        String hannah = "Did Hannah see bees? Hannah did.";
        System.out.println(hannah.length());
        System.out.println(hannah.charAt(15));
        
        String s = "Was it a car or a cat I saw?".substring(9, 12);
        System.out.println(s.length());
        System.out.println(s);
        
        String s1 = "Hi,";
        String s2 = "mom.";
        String s3 = s1 + s2;
        String s4 = s1.concat(s2);

        System.out.println(initials(["Test1", "Test2"]));
        
        
    }
    
    public static String initials(String[] name) {
        String inits = "";
        for (String word : name) {
            inits.concat(word.charAt(0) + ". ");
        }
        return inits;
    }
}