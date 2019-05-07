package com.doumiaotech.chapter2;

public class E07_Incrementable {

    static int increment() {
        return ++StaticTest.i;
    }

    
    public static void main(String[] args) {
        int i = E07_Incrementable.increment();
        System.out.println(i);
    }
}

class StaticTest {
    static int i = 47;
}

/* out
 * 48
 */

