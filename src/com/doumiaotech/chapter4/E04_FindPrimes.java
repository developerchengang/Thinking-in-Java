package com.doumiaotech.chapter4;

public class E04_FindPrimes {
    public static void main(String[] args) {
        int max = 100;
        if(args.length != 0) {
            max = Integer.parseInt(args[0]);
        }

        for(int i = 1; i < max; i++) {
            boolean prime = true;
            for(int j = 2; j < i; j++)
                if(i % j == 0) {
                    prime = false;
                }
            if(prime) {
                System.out.print(i + " ");
            }

        }
    }
}
