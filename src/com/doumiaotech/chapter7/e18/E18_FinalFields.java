package com.doumiaotech.chapter7.e18;

/****************** Exercise 18 *****************
 * Create a class with a static final field and a
 * final field and demonstrate the difference
 * between the two.
 ***********************************************/

public class E18_FinalFields {
    public static void main(String[] args) {
        System.out.println("First object:");
        System.out.println(new WithFinalFields());
        System.out.println("Second object:");
        System.out.println(new WithFinalFields());
    }
}

class SelfCounter {
    private static int count;
    private int id = count++;
    public String toString() { return "SelfCounter " + id; }
}

class WithFinalFields {
    final SelfCounter scf = new SelfCounter();
    static final SelfCounter scsf = new SelfCounter();
    public String toString() {
        return "scf = " + scf + "\nscsf = " + scsf;
    }
}

/* output:
 * First object:
 * scf = SelfCounter 1
 * scsf = SelfCounter 0
 * Second object:
 * scf = SelfCounter 2
 * scsf = SelfCounter 0
 */