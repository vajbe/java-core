package Concurrency.Semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreBasics {
    Semaphore semaphore = new Semaphore(5);

    void useResource(String threadName) {
        System.out.println(threadName + " is trying to get acquired the lock");
        try {
            semaphore.acquire();
            System.out.println(threadName + " has acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            semaphore.release();
            System.out.println(threadName + " has released the lock");
        }
    }

    public static void main(String[] args) {
        SemaphoreBasics s = new SemaphoreBasics();

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            s.useResource(name);
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}
