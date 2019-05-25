package com.doumiaotech.chapter5;

public class E05_OverloadedDog {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark(1);
        dog.bark(1.1);
    }
}

class Dog {
    public void bark() {
        System.out.println("Default bark!");
    }

    public void bark(int i) {
        System.out.println("int bark = howl");
    }

    public void bark(double d) {
        System.out.println("double bark = yip");
    }
}

/* output
 * Default bark!
 * int bark = howl
 * double bark = yip
 */