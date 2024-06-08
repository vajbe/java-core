package Concurrency;

class ThreadDemo extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child: " + i);
            Thread.yield();
        }
    }
}

public class ThreadYeild {
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Parent: " + i);
        }
    }
}
