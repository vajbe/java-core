package Concurrency.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FiboTask extends RecursiveTask<Integer> {

    int n;

    public FiboTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FiboTask leftTask = new FiboTask(n - 1);
        FiboTask righTask = new FiboTask(n - 2);
        leftTask.fork();
        righTask.fork();
        return leftTask.join() + righTask.join();
    }

}

public class Fibonacci {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FiboTask task = new FiboTask(100);
        Integer result = pool.invoke(task);
        System.out.println("Result : " + result);
    }
}
