package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E03_Aliasing {

    private int add(int num) {
       return ++num;
    }

    public static void main(String[] args) {
        int num = 10;
        E03_Aliasing aliasing = new E03_Aliasing();
        print("num:" + num);
        print("aliasing.num:" + aliasing.add(num));

    }
}

/* output:
 *　num:10
 *  aliasing.num:11
 */
