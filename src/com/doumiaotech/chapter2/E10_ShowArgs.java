package com.doumiaotech.chapter2;

public class E10_ShowArgs {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("需要三个参数");
            System.exit(1);
        }
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
    }
}