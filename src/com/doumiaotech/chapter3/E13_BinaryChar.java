package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E13_BinaryChar {
    public static void main(String[] args) {
        E13_BinaryChar.showChat('A');
        E13_BinaryChar.showChat('!');
        E13_BinaryChar.showChat('x');
        E13_BinaryChar.showChat('7');
    }

    private static void showChat(char c) {
        print(c + ": " + Integer.toBinaryString(c));
    }
}

/* output:
 * A: 1000001
 * !: 100001
 * x: 1111000
 * 7: 110111
 */