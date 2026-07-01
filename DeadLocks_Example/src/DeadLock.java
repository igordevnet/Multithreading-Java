import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the first lock.");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("Worker1 acquires the second lock.");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock2.lock();
        System.out.println("Worker2 acquires the second lock.");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        System.out.println("Worker2 acquires the first lock.");

        lock1.unlock();
        lock2.unlock();
    }
}
