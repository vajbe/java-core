package Concurrency.VirtualThreads.FuturesEx;

import java.util.concurrent.Callable;

public class FutureTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Starting callable");
        Thread.sleep(5000);
        System.out.println("Finished callable");
        return "CALLABLE RESULT";
    }

}
