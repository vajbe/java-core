package Concurrency.VirtualThreads;

public class VirtualTask  implements Runnable{

    @Override
    public void run() {
        System.err.println("Starting: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        System.err.println("Ending: "+ Thread.currentThread().getName());

    }
    
}
