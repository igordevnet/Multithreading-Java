import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private final int id;
    private final CountDownLatch latch;

    public Worker(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.latch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        latch.countDown();
    }

    private void doWork() throws InterruptedException{
        Thread.sleep(500);
        System.out.println("Doing some work id: " + id);
    }
}
