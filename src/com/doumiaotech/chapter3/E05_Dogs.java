package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E05_Dogs {

    private String name;
    private String says;

    public static void main(String[] args) {

        E05_Dogs spot = new E05_Dogs();
        spot.name = "spot";
        spot.says = "Ruff!";

        E05_Dogs scruffy = new E05_Dogs();
        scruffy.name = "scruffy";
        scruffy.says = "Wurf!";

        print("dog name:" + spot.name);
        print("dog name:" + scruffy.name);
    }

}

/* output:
 * dog name:spot
 * dog name:scruffy
 */

