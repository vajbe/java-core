package Concurrency.InfiniteLoops;

public class InfiniteLoopVolatileSol {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (running) {
                // Loop never stops

            }
            System.out.println("Thread Stopped");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        running = false;
    }
}
