package Concurrency.HighCPU;

public class HighCPUExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
        t.start();
    }
}
