package com.doumiaotech.chapter5;

public class E11_FinalizeAlwaysCalled {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() called");
    }

    public static void main(String[] args) {
        new E11_FinalizeAlwaysCalled();
        System.gc();
        System.runFinalization();
    }
}
/*output
 * finalize() called
 */