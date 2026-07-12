import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable {

    private final BlockingQueue<User> queue;
    private final Random random;

    public FirstWorker(BlockingQueue<User> queue) {
        this.queue = queue;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                var age = random.nextInt(100);

                var user = User.build(age, "User_" + age);

                queue.put(user);
                System.out.println("Putting item into the queue... " + user);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
