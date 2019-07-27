package com.doumiaotech.chapter7.e15;

/****************** Exercise 15 *****************
 * Create a class with a protected method inside
 * a package. Try to call the protected method
 * outside the package, and explain the results.
 * Now inherit from your class and call the
 * protected method from inside a method of your
 * derived class.
 ***********************************************/

public class E15_ProtectedTest {
    public static void main(String[] args) {
        //! new E15_Protected().f(); // Cannot access
        new Derived().g();
    }
}


class Derived extends E15_Protected {
    public void g() {
        f(); // Accessible in derived class
    }
}

