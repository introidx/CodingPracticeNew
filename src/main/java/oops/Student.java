package oops;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Student {

    public static void main(String[] args) {
        Parent a = new Parent();
        a = new Child();

        Child b = new Child();

    }
}

class Parent{
    int id;
    String name;

    public void printNameAndId(){
        System.out.println("name = " +name + "id = " +id);
    }
}

class Child extends Parent{

}




