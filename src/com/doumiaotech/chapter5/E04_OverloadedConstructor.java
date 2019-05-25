package com.doumiaotech.chapter5;

public class E04_OverloadedConstructor {
    E04_OverloadedConstructor() {
        System.out.println("Default constructor");
    }
    E04_OverloadedConstructor(String s) {
        System.out.println("String arg constructor");
        System.out.println(s);
    }
    public static void main(String args[]) {
        new E04_OverloadedConstructor();
        new E04_OverloadedConstructor("Overloaded");
    }
}
/* output
 * Default constructor
 * String arg constructor
 * Overloaded
 */