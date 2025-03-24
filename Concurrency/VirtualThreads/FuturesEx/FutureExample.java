package Concurrency.VirtualThreads.FuturesEx;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> res = es.submit(new FutureTask());
        while (!res.isDone()) {
            System.out.println("Waiting for res to finish");
        }
        String result = res.get();
        System.out.println(result);

    }
}
