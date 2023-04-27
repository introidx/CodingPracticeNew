package threads;

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 started");
                // put the code you want to run in t1 here
                System.out.println("Thread 1 finished");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 started");
                // put the code you want to run in t2 here
                System.out.println("Thread 2 finished");
            }
        });

        t1.start();
        t1.join(); // wait for t1 to finish
        t2.start();

        System.out.println("Main finished");


    }
}
