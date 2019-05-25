package com.doumiaotech.chapter5;

public class E19_VarargStringArray {
    static void printStrings(String... strs) {
        for(String s : strs)
            System.out.println(s);
    }
    public static void main(String args[]) {
        printStrings("These", "are", "some", "strings");
        printStrings(new String[] { "These", "are", "some", "strings" });
    }
}
/* output
 * These
 * are
 * some
 * strings
 * These
 * are
 * some
 * strings
 * */