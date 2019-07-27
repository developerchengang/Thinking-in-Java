package com.doumiaotech.chapter7.e24;

import static net.mindview.util.Print.print;

/****************** Exercise 24 ****************
 * In Beetle.java, inherit a specific type of
 * beetle from class Beetle, following the same
 * format as the existing classes. Trace and
 * explain the output.
 ***********************************************/

public class E24_JapaneseBeetle {
    public static void main(String[] args) {
        new JapaneseBeetle();
    }
}

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.print("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    private int y1 =
            printInit("Insect.y1 initialized");

    static int printInit(String s) {
        System.out.print(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.print("k = " + k);
        System.out.print("j = " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.print("Beetle constructor");
        Beetle b = new Beetle();
    }
}

class JapaneseBeetle extends Beetle {
    int m = printInit("JapaneseBeetle.m initialized");
    JapaneseBeetle() {
        print("m = " + m);
        print("j = " + j);
    }
    static int x3 =
            printInit("static JapaneseBeetle.x3 initialized");
}
/* output:
 * static Insect.x1 initialized
 * static Beetle.x2 initialized
 * static JapaneseBeetle.x3 initialized
 * i = 9, j = 0
 * Beetle.k initialized
 * k = 47
 * j = 39
 * JapaneseBeetle.m initialized
 * m = 47
 * j = 39
 */