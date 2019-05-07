package com.doumiaotech.chapter2;

public class E05_DataOnly {
    int i;
    double a;
    boolean b;

    @Override
    public String toString() {
        return "E04_DataOnly[i: " + i 
        + ", a: " + a 
        + ", b: " + b + "]";
    }

    public static void main(String[] args) {
        E05_DataOnly dataOnly = new E05_DataOnly();
        dataOnly.i = 47;
        dataOnly.a = 1.1;
        dataOnly.b = false;

        System.out.println(dataOnly.toString());
    }
}

/* output
 * E04_DataOnly[i: 47, a: 1.1, b: false]
 */