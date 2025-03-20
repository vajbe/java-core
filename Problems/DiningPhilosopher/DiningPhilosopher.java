package Problems.DiningPhilosopher;

import java.util.concurrent.Semaphore;

public class DiningPhilosopher {
    private final int numPhilosophers = 5;
    private final Semaphore[] forks = new Semaphore[numPhilosophers];

    DiningPhilosopher() {
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    void think(int philosopher) throws InterruptedException {
        System.out.println(philosopher + " is thinking");
        Thread.sleep(1000);
    }

    void eat(int philosopher) throws InterruptedException {
        System.out.println(philosopher + " is eating");
        Thread.sleep(1000);
    }

    void dine(int philosopher) throws InterruptedException {
        while (true) {
            think(philosopher);

            if (philosopher % 2 == 0) {
                forks[philosopher].acquire();

                forks[(philosopher + 1) % numPhilosophers].acquire();
            } else {
                forks[(philosopher + 1) % numPhilosophers].acquire();
                forks[philosopher].acquire();
            }

            eat(philosopher);
            forks[philosopher].release();
            forks[(philosopher + 1) % numPhilosophers].release();
        }
    }
}
