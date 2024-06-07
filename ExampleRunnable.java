class RunnableDemo implements Runnable {
    public Thread t;
    private String threadName;
    boolean suspended = false;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);

        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread: " + threadName + " i: " + i);
                Thread.sleep(300);

                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interupted");
        }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}

public class ExampleRunnable {
    public static void main(String args[]) {
        RunnableDemo d1 = new RunnableDemo("Thread - 1");
        d1.start();

        RunnableDemo d2 = new RunnableDemo("Thread - 2");
        d2.start();

        try {
            Thread.sleep(1000);
            d1.suspend();
            System.out.println("Suspending thread 1");
            Thread.sleep(1000);
            d1.resume();
            System.out.println("Resuming first thread");

            d2.suspend();
            System.out.println("Suspending thread 2");
            Thread.sleep(1000);
            d2.resume();
            System.out.println("Resuming second thread");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        try {
            System.out.println("Waiting for threads to finish");
            d1.t.join();
            d2.t.join();
        }catch(InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Main thread done");
    }

}