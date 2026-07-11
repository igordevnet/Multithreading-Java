import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        var firstThread = new FirstWorker(queue);
        var secondThread = new SecondWorker(queue);

        new Thread(firstThread).start();
        new Thread(secondThread).start();
    }
}