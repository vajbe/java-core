package Concurrency.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10;
    private final int start, end;
    private final int arr[];

    public SumTask(int arr[], int start, int end) {
        this.start = start;
        this.end = end;
        this.arr = arr;        
    }

    @Override
    protected Long compute() {

        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }

        int mid = (start + end) / 2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask righTask = new SumTask(arr, mid, end);

        leftTask.fork();
        long rightResult = righTask.compute();
        long leftResult = leftTask.join();
        return leftResult + rightResult;
    }
}

public class NumbersSum {
    public static void main(String[] args) {
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(nums, 0, nums.length);
        long result = pool.invoke(task);
        System.out.println("Result is : " + result);

    }
}
