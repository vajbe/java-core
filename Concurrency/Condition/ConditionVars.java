package Concurrency.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Producer implements Runnable {
    List<String> namesResource;
    Condition cond;
    Lock l;
    private final String[] FIRST_NAMES = {
            "Amit", "Vikram", "Sanjay", "Pooja", "Neha", "Ravi", "Manoj", "Sunita", "Kiran", "Rajesh"
    };

    private final Random RANDOM = new Random();

    Producer(List<String> namesList, Condition cond, Lock l) {
        this.namesResource = namesList;
        this.l = l;
        this.cond = cond;
    }

    @Override
    public void run() {
        l.lock();
        while (namesResource.size() < FIRST_NAMES.length) {
            String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
            namesResource.add(firstName);
        }

        try {
            cond.signalAll();
        } catch (Exception e) {

        } finally {
            l.unlock();
        }

    }

}

class Consumer implements Runnable {
    List<String> namesResource;
    Condition cond;
    Lock l;

    Consumer(List<String> namesList, Condition cond, Lock l) {
        this.namesResource = namesList;
        this.l = l;
        this.cond = cond;
    }

    @Override
    public void run() {
        l.lock();
        try {
            cond.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (namesResource.size() > 0) {
            System.out.println("Item received is " + namesResource.remove(0));
        }
    }

}

public class ConditionVars {
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        Condition cond = l.newCondition();
        List<String> names = new ArrayList<>();
        Thread proThread = new Thread(new Producer(names, cond, l));
        Thread conThread = new Thread(new Consumer(names, cond, l));

        conThread.start();
        proThread.start();
        /*
         * try {
         * proThread.join();
         * } catch (InterruptedException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */

    }
}
