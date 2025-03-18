package Concurrency.Starvation;

public class StarvationExample {
    public static void main(String args[]) {
        Runnable task = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

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
