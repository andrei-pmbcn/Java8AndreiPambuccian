/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access.test;

import access.packageone.Alpha;
import access.packageone.Beta;
import access.packageone.Epsilon;
import access.packagetwo.Delta;
import access.packagetwo.Gamma;

/**
 *
 * @author andrei
 */
public class TestVisibility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("---Visibility in class---");
        Alpha alphaObject = new Alpha();
        alphaObject.visibilityInClass();
        System.out.println("---Visibility in superclass---");
        Beta betaObject = new Beta();
        betaObject.visibilityInSuperClass();
        System.out.println("---Visibility outside package---");
        Gamma gammaObject = new Gamma();
        gammaObject.visibilityInOtherPackage();
        System.out.println("---Visibility in superclass outside package---");
        Delta deltaObject = new Delta();
        deltaObject.visibilityInSuperclassOutsidePackage();
        System.out.println("---Visibility in package---");
        Epsilon epsilonObject = new Epsilon();
        epsilonObject.visibilityInPackage();        
        
    }
    
}
