package com.doumiaotech.chapter8.e12;

/****************** Exercise 12 *****************
 * Modify Exercise 9 so it demonstrates the
 * order of initialization of the base classes
 * and derived classes. Now add member objects to
 * both the base and derived classes, and show
 * the order in which their initialization occurs
 * during construction.
 ***********************************************/

public class E12_RodentInitialization {
    public static void main(String args[]) {
        new Hamster();
    }
}
/* output:
 * Member constructor r1
 * Member constructor r2
 * Rodent constructor
 * Member constructor h1
 * Member constructor h2
 * Hamster constructor
 */
