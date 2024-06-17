package Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Livelock livelock = new Livelock();
        new Thread(livelock::operation1, "Thread1").start();
        new Thread(livelock::operation2, "Thread2").start();
    }

    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.SECONDS);
                System.out.println("Operation1: Lock1 acquired");
                Thread.sleep(500);
                if (lock2.tryLock()) {
                    System.out.println("Operation1: Lock2 acquired");
                } else {
                    System.out.println("Operation1: Can't acquire lock2 - Release lock1");
                    lock1.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    public void operation2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.SECONDS);
                System.out.println("Operation2: Lock2 acquired");
                Thread.sleep(500);
                if (lock1.tryLock()) {
                    System.out.println("Operation2: Lock1 acquired");
                } else {
                    System.out.println("Operation2: Can't acquire lock1 - Release lock2");
                    lock2.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
