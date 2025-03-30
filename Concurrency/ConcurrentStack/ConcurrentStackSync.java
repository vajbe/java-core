package Concurrency.ConcurrentStack;

import java.util.ArrayList;

class Stack {
    ArrayList<Integer> arr;

    Stack() {
        arr = new ArrayList<Integer>();
    }

    synchronized void push(int num) {
        arr.add(num);
    }

    synchronized int pop() throws IndexOutOfBoundsException {
        if (arr.isEmpty()) {
            return -1;
        }
        return arr.remove(arr.size() - 1);
    }

    @Override
    public synchronized String toString() {
        String s = "";
        for (Integer integer : arr) {
            if (integer != null) {
                s += " " + integer.toString();
            }
        }
        return s;
    }

    public synchronized int getSize() {
        return arr.size();
    }
}

public class ConcurrentStackSync {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_OPERATIONS = 10000;
        Stack s = new Stack();

        Runnable task = () -> {
            for (int i = 0; i < MAX_OPERATIONS; i++) {
                s.push(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < MAX_OPERATIONS; i++) {
                s.pop();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        // Thread.sleep(5000);
        System.out.println(s.getSize());
    }
}