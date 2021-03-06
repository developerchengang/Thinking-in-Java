package com.doumiaotech.chapter4;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.sqrt;
import static net.mindview.util.Print.printnb;

public class E04_FindPrimes2 {
    public static void main(String[] args) {
        int max = 100;
        if(args.length != 0)
            max = Integer.parseInt(args[0]);
        boolean[] sieve = new boolean[max + 1];
        int limit = (int)floor(sqrt(max));
        printnb(1 + " ");
        if(max > 1)
            printnb(2 + " ");
        for(int i = 3; i <= limit; i += 2)
            if(!sieve[i])
                for(int j = 2 * i; j <= max; j += i)
                    sieve[j] = true;
        for(int i = 3; i <= max; i += 2)
            if(!sieve[i])
                printnb(i + " ");
    }
}
