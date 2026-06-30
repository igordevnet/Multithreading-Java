import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void Producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method call...");
        condition.await();
        System.out.println("Producer method call again...");
        lock.unlock();
    }

    public void Consumer() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method call...");
        condition.signal();
        lock.unlock();
    }
}
