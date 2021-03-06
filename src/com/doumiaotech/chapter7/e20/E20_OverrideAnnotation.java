package com.doumiaotech.chapter7.e20;

import static net.mindview.util.Print.print;

/****************** Exercise 20 ****************
 * Show that the @Override annotation solves the
 * problem from the "final and private" section.
 ***********************************************/

public class E20_OverrideAnnotation {
    public static void main(String[] args) {
        OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
        op2.f();
        op2.g();
    }
}

class WithFinals {
    private final void f() {
        print("WithFinals.f()");
    }

    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivateE20 extends WithFinals {
    // @Override
    private final void f() {
        print("OverridingPrivateE20.f()");
    }

    // @Override
    private void g() {
        print("OverridingPrivateE20.g()");
    }
}

class OverridingPrivate2E20 extends OverridingPrivateE20 {
    // @Override
    public final void f() {
        print("OverridingPrivate2E20.f()");
    }

    // @Override
    public void g() {
        print("OverridingPrivate2E20.g()");
    }
}