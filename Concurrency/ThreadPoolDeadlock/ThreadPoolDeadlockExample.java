package Concurrency.ThreadPoolDeadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDeadlockExample {
    private static ExecutorService es = new ThreadPoolExecutor(
            2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    public static void main(String[] args) {
        Runnable t = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        };

        es.submit(t);
        es.submit(t);
        es.submit(t);

        es.shutdown();
    }
}