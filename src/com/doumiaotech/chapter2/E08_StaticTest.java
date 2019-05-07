package com.doumiaotech.chapter2;

public class E08_StaticTest {

    static int i;

    public static void main(String[] args) {
        E08_StaticTest staticTest1 = new E08_StaticTest();
        E08_StaticTest staticTest2 = new E08_StaticTest();

        System.out.println("staticTest1:" + (++staticTest1.i));
        System.out.println("staticTest2:" + (++staticTest2.i));
    }
}

/* output
 * staticTest1:1
 * staticTest2:2
 */