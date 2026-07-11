import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable {

    private final BlockingQueue<Integer> queue;

    public SecondWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        var counter = 0;

        while (counter > -1) {
            try {
                System.out.println("Taking an item from the queue... " + counter);
                counter = queue.take();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
