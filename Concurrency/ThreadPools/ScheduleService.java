package Concurrency.ThreadPools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdates implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading and updating the data...");
    }

}

public class ScheduleService {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        es.scheduleAtFixedRate(new StockMarketUpdates(), 1, 1, TimeUnit.SECONDS);
    }
}
