package Concurrency;

class SleepInterruptDemo extends Thread {
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("In " + i);
        }
        try {
            System.out.println("Now going to sleep");
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }

    }
}

public class SleepInterrupt {
    public static void main(String[] args) {
        SleepInterruptDemo sd = new SleepInterruptDemo();
        sd.start();
        // sd.interrupt();
        System.out.println("End of main");
    }
}
