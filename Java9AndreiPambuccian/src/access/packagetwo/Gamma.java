/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access.packagetwo;

import access.packageone.Alpha;

/**
 *
 * @author andrei
 */
public class Gamma {
    private int privateGammaVariable = 10;
    protected int protectedGammaVariable = 20;
    int packageGammaVariable = 30;
    public int publicGammaVariable = 40;    
    
    public void visibilityInOtherPackage() {
        Alpha alpha = new Alpha();
        
        //System.out.println("private member visibility:" + alpha.privateAlphaVariable);
        //System.out.println("protected member visibility:" + alpha.protectedAlphaVariable);
        //System.out.println("package member visibility:" + alpha.packageAlphaVariable);
        System.out.println("public member visibility:" + alpha.publicAlphaVariable);    
    }
}
