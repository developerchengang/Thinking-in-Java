package com.doumiaotech.chapter8.e03;

/****************** Exercise 3 *****************
 * Add a new method in the base class of
 * Shapes.java that prints a message, but don't
 * override it in the derived classes. Explain
 * what happens. Now override it in only one of the
 * derived classes and see what happens. Finally,
 * override it in all the derived classes.
 ***********************************************/

public class E03_NewShapeMethod {
    public static void main(String args[]) {
        Shape[] shapes = {
                new Circle(), new Square(), new Triangle(),
        };
        // Make polymorphic method calls:
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}

/* output:
 * Circle.draw()
 * Circle.erase()
 * Circle.msg()
 * Square.draw()
 * Square.erase()
 * Square.msg()
 * Triangle.draw()
 * Triangle.erase()
 * Triangle.msg()
 */