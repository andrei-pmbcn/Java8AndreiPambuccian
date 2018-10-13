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
public class Delta extends Alpha {
    public void visibilityInSuperclassOutsidePackage() {
        //System.out.println("private member visibility:" + privateAlphaVariable);
        System.out.println("protected member visibility:" + protectedAlphaVariable);
        //System.out.println("package member visibility:" + packageAlphaVariable);
        System.out.println("public member visibility:" + publicAlphaVariable);
    }    
}
