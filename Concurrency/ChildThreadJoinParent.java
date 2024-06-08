package Concurrency;

class ChildThread extends Thread {
    static Thread parent;

    public void run() {
        try {
            parent.join();
            System.out.println("Done waiting Parent ");
        } catch (Exception e) {
        }
    }
}

public class ChildThreadJoinParent {
    public static void main(String[] args) throws InterruptedException {
        ChildThread.parent = Thread.currentThread();
        ChildThread ct = new ChildThread();
        ct.start();
        // ct.join(); //Deadlock situation
        Thread.sleep(1000);
        System.out.println("Parent Thread");
    }
}
