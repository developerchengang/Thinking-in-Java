package com.doumiaotech.chapter7.e07;

/****************** Exercise 7 ******************
 * Modify Exercise 5 so A and B have
 * constructors with arguments instead of default
 * constructors. Write a constructor for C and
 * perform all initialization within it.
 ***********************************************/

public class E07_SimpleInheritance2 {
    public static void main(String[] args) {
        new C2("Init string");
    }
}

class A2 {
    public A2(String s) { System.out.println("A2(): " + s); }
}

class B2 {
    public B2(String s) { System.out.println("2B(): " + s); }
}
class C2 extends A2 {
    B2 b;
    public C2(String s) {
        super(s);
        b = new B2(s);
    }
}

/* output:
 * A2(): Init string
 * 2B(): Init string
 */