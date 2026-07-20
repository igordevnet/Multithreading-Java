import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean read(Student student) throws InterruptedException {
        if(lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                System.out.println(student + " start reading " + this);
                Thread.sleep(2000);
                System.out.println(student + " has just finished reading " + this);
            } finally {
                lock.unlock();
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Book #" + id;
    }
}
