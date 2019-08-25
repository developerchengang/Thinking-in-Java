package com.doumiaotech.chapter8.e09;

import static net.mindview.util.Print.print;

/****************** Exercise 9 *****************
 * Create an inheritance hierarchy of Rodent:
 * Mouse, Gerbil, Hamster, etc. In the base
 * class, provide methods that are common to all
 * Rodents, and override these in the derived
 * classes to perform different behaviors
 * depending on the specific type of Rodent.
 * Create an array of Rodent, fill it with
 * different specific types of Rodents, and call
 * your base-class methods to see what happens.
 ***********************************************/

public class E09_Rodents {
    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Gerbil(),
                new Hamster(),
        };

        for(Rodent r : rodents) {
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
        }
    }
}

/* output:
 * Mouse hopping
 * Mouse scurrying
 * Making more Mice
 * Mouse
 * Gerbil hopping
 * Gerbil scurrying
 * Making more Gerbils
 * Gerbil
 * Hamster hopping
 * Hamster scurrying
 * Making more Hamsters
 * Hamster
 */