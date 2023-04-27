package interview;

public class SinchInterview extends Person{


    SinchInterview(int abc) {
        super(abc);
    }

    public static void main(String[] args) {


    }
}

abstract class Person{
    final int abc;

    Person(int abc) {
        this.abc = abc;
    }
}

