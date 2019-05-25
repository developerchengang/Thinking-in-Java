package com.doumiaotech.chapter5;

public class E17_ObjectReferences {
    Test[] array1 = new Test[5];
    public static void main(String args[]) {
// Or as a temporary inside main:
        Test[] array2 = new Test[5];
    }
}

class Test {
    Test(String s) {
        System.out.println("String constructor; s = " + s);
    }
}