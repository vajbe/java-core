package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicIntegerExample e = new AtomicIntegerExample();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                increase();
            }
        }, "Thead1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                increase();
            }
        }, "Thread2");

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("Value of integer is " + atomicInteger);

    }

    public static void increase() {
        for (int i = 0; i < 1000; i++) {
            atomicInteger.getAndIncrement();
        }
    }
}
