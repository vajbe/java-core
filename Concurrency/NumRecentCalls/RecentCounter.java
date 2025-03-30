package Concurrency.NumRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q;

    RecentCounter() {
        this.q = new LinkedList<>();
    }

    int ping(int t) {
        this.q.add(t);
        int start = t - 3000;
        int end = t;
        int counter = 0;
        for (int a : this.q) {
            if (start <= a && a <= end) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }
}
