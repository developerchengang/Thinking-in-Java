package com.doumiaotech.chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;

public class E01_PrintStatements {

    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
        print("Hello, it's: ");
        print(new Date());
    }

}

/* output:
 * Hello, it's:
 * Tue May 07 22:49:49 CST 2019
 * Hello, it's:
 * Tue May 07 22:49:49 CST 2019
 */
