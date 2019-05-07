package com.doumiaotech.chapter2;

public class E09_AutoboxingTest {

    void autoboxing() {
        char c = 'A';
        Character aCharacter = c;
        System.out.println("aCharacter:" + aCharacter);

        byte b = 127;
        Byte aByte = b;
        System.out.println("aByte:" + aByte);

        short s = 512;
        Short aShort = s;
        System.out.println("aShort:" + aShort);

        int i = 1024;
        Integer aInteger = i;
        System.out.println("aInteger:" + aInteger);

        long l = 2048;
        Long aLong = l;
        System.out.println("aLong:" + aLong);

        float f = 1.24f;
        Float aFloat = f;
        System.out.println("aFloat:" + aFloat);

        double d = 3.14;
        Double aDouble = d;
        System.out.println("aDouble:" + aDouble);

        boolean bool = true;
        Boolean aBoolean = bool;
        System.out.println("aBoolean:" + aBoolean);
    }

    public static void main(String[] args) {
        E09_AutoboxingTest autoboxingTest = new E09_AutoboxingTest();
        autoboxingTest.autoboxing();
    }
}

/* output
 * aShort:512
 * aInteger:1024
 * aLong:2048
 * aFloat:1.24
 * aDouble:3.14
 * aBoolean:true
 */