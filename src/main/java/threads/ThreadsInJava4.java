package threads;

class Q {
    int num;
    boolean setValue = false;

    public synchronized void put(int num) {
        while (setValue) {
            try {wait();} catch (Exception e) {}
        }
        setValue = true;
        System.out.println("Put : " + num);
        this.num = num;
        notifyAll();
    }
    /** When we use wait method, we need to use synchronized keyword*/
    public synchronized void get() {
        while (!setValue) {
            try {wait();} catch (Exception e) {}
        }
        setValue = false;
        System.out.println("Get : " + num);
        notifyAll();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            q.put(i++);
            try {Thread.sleep(500);} catch (Exception e){}
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t1 = new Thread(this, "Consumer");
        t1.start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
            try {Thread.sleep(500);} catch (Exception e){}
        }
    }
}

public class ThreadsInJava4 {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
