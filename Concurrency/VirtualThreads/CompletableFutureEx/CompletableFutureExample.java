package Concurrency.VirtualThreads.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ExecutorService cpuExecutor = Executors.newFixedThreadPool(2);
        ExecutorService ioExecutor = Executors.newCachedThreadPool();

        CompletableFuture.supplyAsync(() -> "Hello World", cpuExecutor)
                .thenApplyAsync(s -> s.toUpperCase(), ioExecutor)
                .thenAccept(System.out::println);
        System.out.println("Rest of the program");
    }
}
