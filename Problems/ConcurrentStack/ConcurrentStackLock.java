package Problems.ConcurrentStack;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Stack {
    Lock lock;
    ArrayList<Integer> stack;

    Stack() {
        lock = new ReentrantLock();
        stack = new ArrayList<Integer>();
    }

    void push(int num) {
        lock.lock();
        try {
            this.stack.add(num);
        } finally {
            lock.unlock();
        }
    }

    int pop() {
        lock.lock();
        try {
            if (this.stack.isEmpty()) {
                return -1;
            }
            return this.stack.remove(this.stack.size() - 1);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized String toString() {
        String s = "";
        for (Integer integer : stack) {
            if (integer != null) {
                s += " " + integer.toString();
            }
        }
        return s;
    }

    int getSize() {
        try {
            lock.lock();
            return stack.size();
        } finally {
            lock.unlock();
        }
    }
}

public class ConcurrentStackLock {
    public static void main(String[] args) throws InterruptedException {
        Stack s = new Stack();
        final int MAX_OPS = 10000;
        Runnable task1 = () -> {
            for (int i = 0; i < MAX_OPS; i++) {
                s.push(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < MAX_OPS; i++) {
                s.pop();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(s.getSize());
    }
}
