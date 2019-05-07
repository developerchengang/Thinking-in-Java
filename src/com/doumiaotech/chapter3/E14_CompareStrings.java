package com.doumiaotech.chapter3;

public class E14_CompareStrings {

    public static void main(String[] args) {
        compare("Hello", "Hello");

        String s = new String("Hello");
        compare("Hello", s);
        compare("Hello", "Goodbye");
    }

    private static void pint(String s, boolean b) {
        System.out.println(s + ": " + b);
    }

    private static void compare(String lval, String rval) {
        System.out.println("lval: " + lval + " rval: " + rval);
        pint("lval == rval", lval == rval);
        pint("lval != rval", lval != rval);
        pint("lval.equals(rval)", lval.equals(rval));
    }

}

/* output
 * lval: Hello rval: Hello
 * lval == rval: true
 * lval != rval: false
 * lval.equals(rval): true
 * lval: Hello rval: Hello
 * lval == rval: false
 * lval != rval: true
 * lval.equals(rval): true
 * lval: Hello rval: Goodbye
 * lval == rval: false
 * lval != rval: true
 * lval.equals(rval): false
 */