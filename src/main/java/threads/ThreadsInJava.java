package threads;

import org.springframework.boot.autoconfigure.web.ServerProperties;

public class ThreadsInJava {

    public static void main(String[] args) {
        B b = new B();
        A a = new A();

        a.start();
        b.start();
    }
}

class A extends Thread{

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("A");
            try {Thread.sleep(500);} catch (Exception e) {}
        }
    }

}

class B extends Thread{

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("B");
            try {Thread.sleep(500);} catch (Exception e) {}
        }
    }
}
