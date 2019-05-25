package com.doumiaotech.chapter5;

public class E09_ThisConstructorCall {
    public E09_ThisConstructorCall(String  s) {
        System.out.println("s = " + s);
    }
    public E09_ThisConstructorCall(int i) {
        this("i = " + i);
    }

    public static void main(String[] args) {
        new E09_ThisConstructorCall("String call");
        new E09_ThisConstructorCall(47);
    }
}
/* output
 * s = String call
 * s = i = 47
 */
