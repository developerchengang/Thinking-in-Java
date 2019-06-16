package com.doumiaotech.chapter6.e08;

import com.doumiaotech.chapter6.e08.connection.Connection;
import com.doumiaotech.chapter6.e08.connection.ConnectionManager;

public class E08_ConnectionManager {
    public static void main(String[] args) {
        Connection c = ConnectionManager.getConnection();
        while(c != null) {
            System.out.println(c);
            c.doSomething();
            c = ConnectionManager.getConnection();
        }
    }
}
/* output:
 * Connection 0
 * Connection 1
 * Connection 2
 * Connection 3
 * Connection 4
 * Connection 5
 * Connection 6
 * Connection 7
 * Connection 8
 * Connection 9
 */