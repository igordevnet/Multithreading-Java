import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable {

    private final BlockingQueue<User> queue;

    public SecondWorker(BlockingQueue<User> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Taking an item from the queue... " + queue.take());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
