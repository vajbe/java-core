package Concurrency.VirtualThreads;

public class VirtualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        var builder = Thread.ofVirtual().name("Virtual-", 0);

        var t1 = builder.start(new VirtualTask());
        var t2 = builder.start(new VirtualTask());
        t1.join();
        t2.join();
    }
}
