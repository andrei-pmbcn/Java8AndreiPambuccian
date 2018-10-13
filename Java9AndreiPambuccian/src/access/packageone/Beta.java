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
public class Beta extends Alpha {
    private int privateBetaVariable = 10;
    protected int protectedBetaVariable = 20;
    int packageBetaVariable = 30;
    public int publicBetaVariable = 40;

    public void visibilityInSuperClass() {
        //System.out.println("private member visibility:" + privateAlphaVariable);
        System.out.println("protected member visibility:" + protectedAlphaVariable);
        System.out.println("package member visibility:" + packageAlphaVariable);
        System.out.println("public member visibility:" + publicAlphaVariable);
    }

}
