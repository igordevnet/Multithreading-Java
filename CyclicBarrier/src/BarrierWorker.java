import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierWorker implements Runnable {

    private final int id;
    private final CyclicBarrier barrier;
    private final Random random;

    public BarrierWorker(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        doWorker();
    }

    private void doWorker() {
        System.out.println("Job id: " + id + " executed using Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("After Job id: " + id + " executed using Thread: " + Thread.currentThread().getName());
    }
}
