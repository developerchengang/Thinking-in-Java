package com.doumiaotech.chapter5;

public class E12_TankWithTerminationCondition {
    public static void main(String[] args) {
        new Tank().empty();
        new Tank();
        // Don't empty the second one
        System.gc(); // Force finalization?
        System.runFinalization();
    }
}

class Tank {
    static int counter;
    int id = counter++;
    boolean full;

    public Tank() {
        System.out.println("Tank " + id + " created");
        full = true;
    }

    public void empty() {
        full = false;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (full)
            System.out.println("Error: tank " + id + " must be empty at cleanup");
        else
            System.out.println("Tank " + id + " cleaned up OK");
    }

    public String toString() {
        return "Tank " + id;
    }
}
/* output
 * Tank 0 created
 * Tank 1 created
 * Tank 0 cleaned up OK
 * Error: tank 1 must be empty at cleanup
 */