package com.doumiaotech.chapter7.e21;

/****************** Exercise 21 ****************
 * Create a class with a final method. Inherit
 * from that class and attempt to override that
 * method.
 ***********************************************/

public class E21_FinalMethod extends WithFinalMethod {
    //void f() {}
    public static void main(String[] args) {

    }
}

class WithFinalMethod {
    final void f() {}
}
