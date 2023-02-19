package threads;

import javax.annotation.security.RunAs;

public class ThreadsInJava2 {

    public static void main(String[] args) throws Exception {
        /**
         // method 1
        Runnable b = new B1();
        Runnable a = new A1();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
        try {Thread.sleep(10);} catch (Exception e) {}
        t2.start();
        */

        /** method 2 using lambda

        * we do not need to create an extra class, we can have
        * same functionality using lambda and runnable (Anonymous class)
        Runnable obj1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("A");
                try {Thread.sleep(500);} catch (Exception e) {}
            }
        };

        Runnable obj2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("B");
                try {Thread.sleep(500);} catch (Exception e) {}
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
        */
        /** Method 3*/
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("A");
                try {Thread.sleep(500);} catch (Exception e) {}
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("B");
                try {Thread.sleep(500);} catch (Exception e) {}
            }
        });

        t3.start();
        t4.start();

        /** t3.getName(); // to get the name of the thread
        System.out.println(t3.getPriority()); // set priority to the threads
        System.out.println(t4.getPriority());
         // priority goes from 1 -> 10 (one means low priority, 10 means high priority)

        t3.setPriority(6);
        System.out.println(t3.getPriority());
        */


        t3.join(); // it will block the main thread from execution until t3 completes
        t4.join();

        System.out.println("Bye");

    }
}

class A1 implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("A");
            try {Thread.sleep(500);} catch (Exception e) {}
        }
    }

}

class B1 implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("B");
            try {Thread.sleep(500);} catch (Exception e) {}
        }
    }
}
