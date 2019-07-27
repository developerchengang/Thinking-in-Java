package com.doumiaotech.chapter7.e09;

/****************** Exercise 9 *****************
 * Create a class called Root and an instance of
 * each of three classes, Component1, Component2, and
 * Component3. Derive a class Stem from Root that
 * also contains an instance of each "component."
 * Default constructors for each class should
 * print a message about that class.
 ***********************************************/

public class E09_ConstructorOrder2 {
    public static void main(String[] args) {
        new Stem();
    }
}

class Component1 {
    public Component1() { System.out.println("Component1"); }
}
class Component2 {
    public Component2() { System.out.println("Component2"); }
}
class Component3 {
    public Component3() { System.out.println("Component3"); }
}
class Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
    public Root() {
        System.out.println("Root");
    }
}

class Stem extends Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
}
/* output:
 * Component1
 * Component2
 * Component3
 * Root
 * Component1
 * Component2
 * Component3
 * Stem
 */