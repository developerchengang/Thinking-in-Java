package com.doumiaotech.chapter4;

import java.util.Random;

public class E02_RandomInts {

    private static Random random = new Random();

    private static void compareRand() {
        int a = random.nextInt();
        int b = random.nextInt();
        System.out.println("a = " + a + ", b = " + b);
        if(a < b)
            System.out.println("a < b");
        else if(a > b)
            System.out.println("a > b");
        else
            System.out.println("a = b");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 25; i++) {
            compareRand();
        }
    }
}
/* output
 * a = 592246956, b = -2032685018
 * a > b
 * a = -313829743, b = -166615487
 * a < b
 * a = -1575942137, b = -1321345781
 * a < b
 * a = 2061020702, b = -549872961
 * a > b
 * a = 1940658630, b = 1995464815
 * a < b
 * a = -1877336688, b = 427152759
 * a < b
 * a = 1554440873, b = 857052485
 * a > b
 * a = 1606207274, b = -361455374
 * a > b
 * a = 1821544186, b = 78960714
 * a > b
 * a = -188070452, b = -1709708757
 * a > b
 * a = -644093947, b = -1628196247
 * a > b
 * a = -1661365879, b = 1957923734
 * a < b
 * a = -1943610170, b = -1794063008
 * a < b
 * a = 307304822, b = -810105757
 * a > b
 * a = 1187865060, b = 1812881058
 * a < b
 * a = 1659905732, b = 1474256899
 * a > b
 * a = -849879842, b = 1320735871
 * a < b
 * a = 1688395025, b = 1694061034
 * a < b
 * a = 1140100739, b = 483594625
 * a > b
 * a = 1749380090, b = -2045392489
 * a > b
 * a = 1247195303, b = 1710617113
 * a < b
 * a = 1144014324, b = -1907293487
 * a > b
 * a = 465386259, b = 1247107195
 * a < b
 * a = 640708700, b = 1039029810
 * a < b
 * a = 2020377533, b = -244835643
 * a > b
 */