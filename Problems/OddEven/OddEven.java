package Problems.OddEven;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

class MyRunnable implements Runnable {
    int start;
    int end;
    // AtomicInteger numEven = new AtomicInteger(0);
    int numEven = 0;

    boolean isEven(int num) {
        return num % 2 == 0;
    }

    MyRunnable(int start, int end) {
        this.start = start;
        this.end = end;
        numEven = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (isEven(i)) {
                // numEven.incrementAndGet();
                numEven++;
            }
        }
    }

    int getEvenCount() {
        // return numEven.get();
        return numEven;
    }
}

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        int NUM_THREADS = 1;
        int MAX_NUM = 999999999;
        int start = 0;
        int end = 0;
        Instant now = Instant.now();
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<MyRunnable> runs = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            end = (MAX_NUM / NUM_THREADS) + start;
            System.out.println("Start: " + String.valueOf(start) + " End:" + String.valueOf(end));
            MyRunnable r = new MyRunnable(start, end);
            start = Math.min(end, MAX_NUM) + 1;
            Thread t = new Thread(r);
            threads.add(t);
            runs.add(r);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Time elapased at => " + Duration.between(now, Instant.now()).toSeconds() + "s");
        int count = 0;
        for (MyRunnable r : runs) {
            count += r.getEvenCount();
        }
        System.out.println(count);
    }
}
