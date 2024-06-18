package Concurrency;

class ThreadDemo extends Thread {
    // Default constructor
    ThreadDemo(String name) {
        super(name);
    }

    public void run() {
        System.out.println("This run is getting run by " + Thread.currentThread().getName());
        System.out.println("This run is getting run by " + Thread.currentThread().getThreadGroup().getName());
    }
}

class BasicThread {
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo("VivekThread"); // Using default constructor
        t.start(); // Start the first thread
        System.out.println("Name of current Thread here in main method " + Thread.currentThread().getName());
        Thread.currentThread().setName("NeWName");
        System.out.println("Name of current Thread here in main method " + Thread.currentThread().getName());
    }
}
