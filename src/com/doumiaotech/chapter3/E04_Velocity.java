package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E04_Velocity {

    public static void main(String[] args) {
        if (args.length < 2) {
            print("长度小于２");
            System.exit(1);
        }

        float distance = Float.parseFloat(args[0]);
        float time = Float.parseFloat(args[1]);
        print("Velocity = " + distance / time + " m/s");
    }

}
/* output:
 * Velocity = 9.53125 m/s
 */
