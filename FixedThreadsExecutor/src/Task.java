import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id: " + id + " is in work - Thread id: " + Thread.currentThread().threadId());
        long duration = (long) (Math.random() * 5) ;

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
