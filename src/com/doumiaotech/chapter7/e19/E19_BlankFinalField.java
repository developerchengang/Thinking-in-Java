package com.doumiaotech.chapter7.e19;

/****************** Exercise 19 *****************
 * Create a class with a blank final reference to
 * an object. Perform initialization of the
 * blank final inside all constructors.
 * Demonstrate that the final must
 * be initialized before use, and cannot
 * be changed once initialized.
 ***********************************************/

public class E19_BlankFinalField {
    public static void main(String[] args) {
        WithBlankFinalField wbff = new WithBlankFinalField(10);
        System.out.println(wbff.geti());
    }
}

class WithBlankFinalField {

    private final Integer i;

    // Without this constructor, you'll get a compiler error:
// "variable i might not have been initialized"
    public WithBlankFinalField(int ii) {
        i = new Integer(ii);
    }

    public Integer geti() {
// This won't compile. The error is:
// "cannot assign a value to final variable i"
        /*if (i == null) {
            i = new Integer(47);
        }*/
        return i;
    }
}

/* output:
 * 10
 */