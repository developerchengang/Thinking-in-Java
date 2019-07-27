package com.doumiaotech.chapter7.e17;

/****************** Exercise 17 *****************
 * Modify Exercise 16 so Frog overrides the
 * method definitions from the base class
 * (provides new definitions using the same
 * method signatures). Note what happens in
 * main().
 ***********************************************/
public class E17_Frog2 {
    public static void main(String[] args) {
        Amphibian a = new Frog2();
        a.moveInWater();
        a.moveOnLand();
    }
}

class Amphibian {
    public void moveInWater() {
        System.out.println("Moving in Water");
    }
    public void moveOnLand() {
        System.out.println("Moving on Land");
    }
}


class Frog2 extends Amphibian {
    public void moveInWater() {
        System.out.println("Frog swimming");
    }
    public void moveOnLand() {
        System.out.println("Frog jumping");
    }
}

/* output:
 * Frog swimming
 * Frog jumping
 */