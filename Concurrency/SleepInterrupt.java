package Concurrency;

class SleepInterruptDemo extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("In child");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }

    }
}

public class SleepInterrupt {
    public static void main(String[] args) {
        SleepInterruptDemo sd = new SleepInterruptDemo();
        sd.start();
        sd.interrupt();
        System.out.println("End of main");
    }
}
