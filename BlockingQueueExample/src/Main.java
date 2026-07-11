import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

        var firstThread = new FirstWorker(queue);
        var secondThread = new SecondWorker(queue);

        new Thread(firstThread).start();
        new Thread(secondThread).start();
    }
}