package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Deadlock deadlock = new Deadlock();
        new Thread(() -> {
            try {
                deadlock.worker1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "worker1").start();
        new Thread(() -> {
            try {
                deadlock.worker2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "worker2").start();
    }

    public void worker1() throws Exception {
        lock1.lock();
        System.out.println("Worker1 acquires lock1");
        Thread.sleep(500);
        lock2.lock();
        System.out.println("Worker1 acquires lock2");
        System.out.println("Worker1 finished execution");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() throws Exception {
        lock1.lock();
        System.out.println("Worker2 acquires lock2");
        Thread.sleep(500);
        lock2.lock();
        System.out.println("Worker2 acquires lock1");
        System.out.println("Worker2 finished exeuction");
        lock1.unlock();
        lock2.unlock();
    }
}
