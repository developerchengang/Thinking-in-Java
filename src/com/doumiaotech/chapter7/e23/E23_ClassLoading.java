package com.doumiaotech.chapter7.e23;

/****************** Exercise 23 ****************
 * Prove that class loading takes place only
 * once and may be caused by either the creation
 * of the first instance of that class or by
 * accessing a static member.
 ***********************************************/

public class E23_ClassLoading {
    public static void main(String[] args) {
        System.out.println("Calling static member");
        LoadTest.staticMember();
        System.out.println("Creating an object");
        new LoadTest();
    }
}

class LoadTest {
    // The static clause is executed
    // upon class loading:
    static {
        System.out.println("Loading LoadTest");
    }
    static void staticMember() {}
}
/* output:
 * Calling static member
 * Loading LoadTest
 * Creating an object
 */