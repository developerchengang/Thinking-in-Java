package com.doumiaotech.chapter6.e08.connection;

public class Connection {
    private static int counter = 0;
    private int id = counter++;
    Connection() {}
    public String toString() {
        return "Connection " + id;
    }
    public void doSomething() {}
}
