package com.doumiaotech.chapter8.e14;

import static net.mindview.util.Print.print;

/****************** Exercise 14 *****************
 * Modify Exercise 12 so one of the member
 * objects is a shared object with reference
 * counting, and demonstrate that it works
 * properly.
 ***********************************************/

public class E14_SharedRodentInitialization {
    public static void main(String args[]) {
        SharedMember sm = new SharedMember();
        Rodent[] rodents = {
                new Hamster(sm),
                new Gerbil(sm),
                new Mouse(sm),
        };
        for (Rodent r : rodents)
            r.dispose();
    }
}


class NonSharedMember {
    public NonSharedMember(String id) {
        print("Non shared member constructor " + id);
    }
}

class SharedMember {
    private int refcount;

    public void addRef() {
        print("Number of references " + ++refcount);
    }

    protected void dispose() {
        if (--refcount == 0)
            print("Disposing " + this);
    }

    public SharedMember() {
        print("Shared member constructor");
    }

    public String toString() {
        return "Shared member";
    }
}

/* output:
 * Shared member constructor
 * Non shared member constructor r1
 * Non shared member constructor r2
 * Rodent constructor
 * Number of references 1
 * Non shared member constructor
 * Non shared member constructor
 * Hamster constructor
 * Non shared member constructor
 * Non shared member constructor
 * Rodent constructor
 * Number of references 2
 * Non shared member constructor
 * Non shared member constructor
 * Gerbil constructor
 * Non shared member constructor
 * Non shared member constructor
 * Rodent constructor
 * Number of references 3
 * Non shared member constructor
 * Non shared member constructor
 * Mouse constructor
 * Disposing Hamster
 * Disposing Gerbil
 * Disposing Mouse
 * Disposing Shared member
 * */