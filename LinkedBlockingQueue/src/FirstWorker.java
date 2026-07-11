import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable {

    private final BlockingQueue<Integer> queue;

    public FirstWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true) {
            try {
                if (counter == 10) {
                    queue.put(-1);
                    break;
                }

                queue.put(counter);
                counter++;
                System.out.println("Putting item into the queue... " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
