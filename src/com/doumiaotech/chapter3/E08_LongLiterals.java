package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E08_LongLiterals {
    public static void main(String[] args) {
        long l1 = 0xa;
        print(Long.toBinaryString(l1));
        long l2 = 012;
        print(Long.toBinaryString(l2));
    }
}

/* output
 * 1010
 * 1010
 */
