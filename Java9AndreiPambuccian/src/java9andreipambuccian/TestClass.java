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
public class TestClass {
    protected static class NestedTestClass {
        public static int x = 1;
    }

    NestedTestClass c;
    
    TestClass() {
        c = new NestedTestClass();
    }    
}
