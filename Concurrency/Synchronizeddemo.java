package Concurrency;

class Display {
    public synchronized void greet(String name) {
        for (int i = 0; i < 3; i++) {
            System.out.print("GOOD MORNING:");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println(name);
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.greet(name);
    }
}

public class Synchronizeddemo {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Vivek");
        MyThread t2 = new MyThread(d, "Agastya");
        MyThread t3 = new MyThread(d, "Nikhil");

        t1.start();
        t2.start();
        t3.start();
    }
}
