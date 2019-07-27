package com.doumiaotech.chapter7.e08;

/****************** Exercise 8 *****************
 * Create a base class with only a non-default
 * constructor, and a derived class with both a
 * default (no-arg) and non-default constructor.
 * Call the base-class constructor in the
 * derived-class constructors.
 ***********************************************/

public class E08_CallBaseConstructor {
    public static void main(String[] args) {
        new DerivedTwoConstructors();
        new DerivedTwoConstructors(74);
    }
}

class BaseNonDefault {
    public BaseNonDefault(int i) {}
}

class DerivedTwoConstructors extends BaseNonDefault {
    public DerivedTwoConstructors() {
        super(47);
    }

    public DerivedTwoConstructors(int i) { super(i); }
}