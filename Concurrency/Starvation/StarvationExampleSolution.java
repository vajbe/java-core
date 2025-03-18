package Concurrency.Starvation;
import java.util.concurrent.locks.ReentrantLock;

class StarvationExampleSolution {
    private static final ReentrantLock lock = new ReentrantLock(true); // Fair lock

    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " is running");
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread highPriority = new Thread(task);
        highPriority.setPriority(Thread.MAX_PRIORITY);

        Thread lowPriority = new Thread(task);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
