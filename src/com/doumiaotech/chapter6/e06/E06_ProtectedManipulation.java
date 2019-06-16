package com.doumiaotech.chapter6.e06;

public class E06_ProtectedManipulation {
    public static void main(String[] args) {
        WithProtected wp = new WithProtected();
        wp.i = 47;
        System.out.println("wp.i = " + wp.i);
    }
}

class WithProtected {
    protected int i;
}
/* output:
 * wp.i = 47
 */