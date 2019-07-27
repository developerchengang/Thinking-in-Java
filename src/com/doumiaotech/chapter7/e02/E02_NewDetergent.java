package com.doumiaotech.chapter7.e02;

import static net.mindview.util.Print.print;

/****************** Exercise 2 *****************
 * Inherit a new class from class Detergent.
 * Override scrub() and add a new method called
 * sterilize().
 ***********************************************/

public class E02_NewDetergent {
    public static void main(String[] args) {
        NewDetergent nd = new NewDetergent();
        nd.dilute();
        nd.scrub();
        nd.sterilize();
        System.out.println(nd);
    }
}

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        print(x);
    }
}

class Detergent extends Cleanser {

    public void scrub() {
        append("Detergent.scrub()");
        super.scrub(); // 调用父类方法
    }

    public void foam() {
        append("foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class");
        Cleanser.main(args);
    }
}

class NewDetergent extends Detergent {
    public void scrub() {
        append(" NewDetergent.scrub()");
        super.scrub(); // Doesn't have to be first
    }

    public void sterilize() { append(" sterilize()"); }
}

/* output:
 * Cleanser dilute() NewDetergent.scrub() Detergent.scrub()
 * scrub() sterilize()
 */
