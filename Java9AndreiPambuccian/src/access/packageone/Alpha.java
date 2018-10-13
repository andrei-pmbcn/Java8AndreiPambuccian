/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access.packageone;

/**
 *
 * @author andrei
 */
public class Alpha {
    private int privateAlphaVariable = 10;
    protected int protectedAlphaVariable = 20;
    int packageAlphaVariable = 30;
    public int publicAlphaVariable = 40;
    
    public void visibilityInClass() {
        System.out.println("private member visibility:" + privateAlphaVariable);
        System.out.println("protected member visibility:" + protectedAlphaVariable);
        System.out.println("package member visibility:" + packageAlphaVariable);
        System.out.println("public member visibility:" + publicAlphaVariable);
    }
}
