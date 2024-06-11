package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentRequestHandler
 */
public class ConcurrentRequestHandler {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            final int processId = i;
            es.submit(() -> process(processId));
        }

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
    }

    public static void process(int processId) {
        System.out.println("Processing request " + processId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}