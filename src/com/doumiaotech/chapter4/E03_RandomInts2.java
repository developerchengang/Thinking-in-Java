package com.doumiaotech.chapter4;

import java.util.Random;

public class E03_RandomInts2 {
    private static Random random = new Random();

    private static void compareRand() {
        int a = random.nextInt();
        int b = random.nextInt();
        System.out.println("a = " + a + ", b = " + b);
        if (a < b)
            System.out.println("a < b");
        else if (a > b)
            System.out.println("a > b");
        else
            System.out.println("a = b");
    }

    public static void main(String[] args) {
        while (true)
            compareRand();
    }
}
