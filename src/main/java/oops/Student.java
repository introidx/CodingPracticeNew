package oops;

import java.util.Collections;
import java.util.HashMap;

public class Student extends School {

    public static void main(String[] args) {
        int b =10;
        SampleTest n = a -> {
            int c = a + b;
            return c;
        };

        System.out.println(n.sum(10));
    }





    //    @Override
//    public void setName(String name) {
//        super.setName(name);
//    }
//
//    @Override
//    public void calculateAge(int age) {
//        super.calculateAge(age);
//    }
}

interface SampleTest{
    int sum(int t);
}

class Person{
    String name;
    int age;

    public void setName(String name){
        this.name =name;
    }

    public void calculateAge(int age){
        this.age = age;
    }
}

abstract class School{
    public void schoolName(){
        System.out.println("abs");
    }
}

interface College{
     default public void schoolName(){

    }
}
