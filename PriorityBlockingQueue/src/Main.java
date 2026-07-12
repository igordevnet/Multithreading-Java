import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<User> queue = new PriorityBlockingQueue<>();

        new Thread(new FirstWorker(queue)).start();
        new Thread(new SecondWorker(queue)).start();
    }
}