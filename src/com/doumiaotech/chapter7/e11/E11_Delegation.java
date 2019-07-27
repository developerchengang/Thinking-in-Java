package com.doumiaotech.chapter7.e11;

import static net.mindview.util.Print.print;

/****************** Exercise 11 *****************
 * Modify Detergent.java so it uses delegation.
 ***********************************************/

public class E11_Delegation {
    public static void main(String[] args) {
        DetergentDelegation.main(args);
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

class DetergentDelegation {
    private Cleanser cleanser = new Cleanser();

    // Delegated methods:
    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() { cleanser.dilute(); }
    public void apply() { cleanser.apply(); }
    public String toString() { return cleanser.toString(); }
    public void scrub() {
        append(" DetergentDelegation.scrub()");
        cleanser.scrub();
    }
    public void foam() { append(" foam()"); }

    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
}
/* output:
 * Cleanser dilute() apply() DetergentDelegation.scrub()
 * scrub() foam()
 * Testing base class:
 * Cleanser dilute() apply() scrub()
 */
