package Concurrency.ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Job implements Runnable {
    int id;

    Job(int i) {
        this.id = i;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        long duration = (long) Math.random() + 3;
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Thread: " + id + " Duration: " + duration);

    }

}

public class FixedThread {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 12; i++) {
            es.execute(new Job(i));
        }
        /* es.shutdown(); */
    }
}
