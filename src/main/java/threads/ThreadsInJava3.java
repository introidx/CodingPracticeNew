package threads;

public class ThreadsInJava3 {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++)
                    c.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++)
                    c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
        /**
         * Without using synchronized we will get count = 1558 or something
         * not the desired 2000. because, it may happen that two threads are
         * using the increment() function at the same time.
         */
    }
}

class Counter {

    int count = 0;

    public synchronized void increment() {
        count++;
    }
}
