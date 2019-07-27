package com.doumiaotech.chapter7.e03;

import static net.mindview.util.Print.print;

/****************** Exercise 3 ******************
 * Even if you don't create a constructor for
 * Cartoon(), the compiler will synthesize a
 * default constructor that calls the base-class
 * constructor. Prove that assertion.
 ***********************************************/

public class E03_CartoonWithDefCtor {
    public static void main(String[] args) {
        new CartoonWithDefCtor ();
    }
}

class Art {
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        print("Drawing constructor");
    }
}

class CartoonWithDefCtor extends Drawing {
    /*CartoonWithDefCtor() {
        System.out.println("CartoonWithDefCtor constructor");
    }*/
}

/* output:
 * Art constructor
 * Drawing constructor
 */
