package com.doumiaotech.chapter3;

import static net.mindview.util.Print.print;

public class E02_Aliasing {



    public static void main(String[] args) {
        Student student1 = new Student();
        student1.score = 88.8f;

        print();

        Student student2 = new Student();
        student2.score = 77.5f;

        print("赋值前：student1.score" + student1.score + "\tstudent2.score" + student2.score);

        student2 = student1;

        student1.score = 100f;

        print("赋值后：student1.score" + student1.score + "\tstudent2.score" + student2.score);
    }
}

class Student {
    float score;
}

/* output:
 * 赋值前：student1.score88.8	student2.score77.5
 * 赋值后：student1.score100.0	student2.score100.0
 */