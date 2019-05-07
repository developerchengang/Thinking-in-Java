package com.doumiaotech.chapter2;

public class E06_Storage {

    int storage(String s) {
        return s.length() * 2;
    }
    public static void main(String[] args) {
        E06_Storage storage = new E06_Storage();
        String helloWorld = "Hello, World";
        int storageLength = storage.storage(helloWorld);
        System.out.println("storage长度:" + storageLength);
    }
}
/* output
 * storage长度:24
 */