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
public class TestClass2 extends TestClass {
    
    protected static class NestedTestClass2 extends NestedTestClass {
        public static int y = 2;        
    }
    
    NestedTestClass2 c;
    
    TestClass2() {
        c = new NestedTestClass2();
    }
}
