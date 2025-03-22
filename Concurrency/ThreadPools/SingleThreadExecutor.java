package Concurrency.ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    int id;

    Task(int i) {
        this.id = i;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long duration = (long) Math.random() + 2;

        System.out.println("Job: " + name + " Duration: " + duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            es.submit(new Task(i));
        }
        es.shutdown();
    }
}
