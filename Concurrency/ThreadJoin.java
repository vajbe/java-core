package Concurrency;

class ThreadDemoJoin extends Thread {
    ThreadDemoJoin() {

    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread");
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }

    }
}

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemoJoin t = new ThreadDemoJoin();
        t.start();
        t.join(200);
        // t.join();
        System.out.println("Done waiting");
    }
}
