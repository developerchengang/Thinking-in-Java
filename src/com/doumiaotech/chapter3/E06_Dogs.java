package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E06_Dogs {
    private String name;
    private String says;

    public static void main(String[] args) {

        E06_Dogs spot = new E06_Dogs();
        spot.name = "spot";
        spot.says = "Ruff!";

        E06_Dogs scruffy = new E06_Dogs();
        scruffy.name = "scruffy";
        scruffy.says = "Wurf!";

        E06_Dogs dog3 = new E06_Dogs();

        dog3 = spot;


        print("dog name:" + spot.name);
        print("dog name:" + scruffy.name);
        print("dog3.name == spot.name:" + (dog3.name == spot.name));
        print("dog3.name.equals(spot.name):" + (dog3.name.equals(spot.name)));
        print("dog3 == spot:" + (dog3 == spot));
        print("dog3.equals(spot):" + (dog3.equals(spot)));

        print("spot.name == scruffy.name:" + (spot.name == scruffy.name));
        print("spot.name.equals(scruffy.name):" + (spot.name.equals(scruffy.name)));
        print("spot == scruffy:" + (spot == scruffy));
        print("spot.equals(scruffy):" + (spot.equals(scruffy)));


    }
}

/* output
 * dog name:spot
 * dog name:scruffy
 * dog3.name == spot.name:true
 * dog3.name.equals(spot.name):true
 * dog3 == spot:true
 * dog3.equals(spot):true
 * spot.name == scruffy.name:false
 * spot.name.equals(scruffy.name):false
 * spot == scruffy:false
 * spot.equals(scruffy):false
 */
