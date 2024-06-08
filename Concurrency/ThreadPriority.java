package Concurrency;

class ThreadRun implements Runnable {
    public void run() {
        System.out
                .println("Thread Priority - " + Thread.currentThread().getPriority() + " : Thread Name - "
                        + Thread.currentThread().getName());
    }
}

public class ThreadPriority {

    public static void main(String[] args) {

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        /*
         * Thread.currentThread().setPriority(20);
         * IllegalArgumentException
         */

        ThreadRun r = new ThreadRun();
        Thread t1 = new Thread(r, "Prio-1");
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(r, "Prio-2");
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        System.out.println("My priority " + Thread.currentThread().getPriority());
    }
}
