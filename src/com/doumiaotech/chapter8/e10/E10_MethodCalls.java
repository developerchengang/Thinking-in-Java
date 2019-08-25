package com.doumiaotech.chapter8.e10;

/****************** Exercise 10 *****************
 * Create a base class with two methods. In the
 * first method, call the second method. Inherit
 * a class and override the second method. Create
 * an object of the derived class, upcast it to
 * the base type, and call the first method.
 * Explain what happens.
 ***********************************************/

public class E10_MethodCalls {
    public static void main(String args[]) {
        TwoMethods x = new Inherited();
        x.m1();
    }
}
/* output:
 * Inside m1, calling m2
 * Inside Inherited.m2
 */
