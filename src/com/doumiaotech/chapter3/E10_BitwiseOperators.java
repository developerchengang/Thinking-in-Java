package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E10_BitwiseOperators {
    public static void main(String[] args) {
        int i1 = 0xaaaaaaaa;
        int i2 = 0x55555555;

        print("i1 = " + Integer.toBinaryString(i1));
        print("i2 = " + Integer.toBinaryString(i2));
        print("~i1 = " + Integer.toBinaryString(~i1));
        print("~i2 = " + Integer.toBinaryString(~i2));


        print("i1 & i1 = " + Integer.toBinaryString(i1 & i1));
        print("i1 | i1 = " + Integer.toBinaryString(i1 | i1));
        print("i1 ^ i1 = " + Integer.toBinaryString(i1 ^ i1));
        print("i1 & i2 = " + Integer.toBinaryString(i1 & i2));
        print("i1 | i2 = " + Integer.toBinaryString(i1 | i2));
        print("i1 ^ i2 = " + Integer.toBinaryString(i1 ^ i2));
    }
}

/* output:
 * i1 = 10101010101010101010101010101010
 * i2 = 1010101010101010101010101010101
 * ~i1 = 1010101010101010101010101010101
 * ~i2 = 10101010101010101010101010101010
 * i1 & i1 = 10101010101010101010101010101010
 * i1 | i1 = 10101010101010101010101010101010
 * i1 ^ i1 = 0
 * i1 & i2 = 0
 * i1 | i2 = 11111111111111111111111111111111
 * i1 ^ i2 = 11111111111111111111111111111111
 */
