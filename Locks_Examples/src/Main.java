import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int counter = 0;
    private static Lock lock = new ReentrantLock(true);

    public static void increment() {
        try {
        lock.lock();
        counter++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread td = new Thread(() -> {
            for(var i = 0;i<1000;i++) {
                increment();
                System.out.println("Current number: " + counter);
            }

            System.out.println("Last number: " + counter);
        });

        Thread td2 = new Thread(() -> {
            for(var i = 0;i<1000;i++) {
                increment();
                System.out.println("Current number: " + counter);
            }

            System.out.println("Last number: " + counter);
        });

        td.start();
        td2.start();

        try {
            td.join();
            td2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}