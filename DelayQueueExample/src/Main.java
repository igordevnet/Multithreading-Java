import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();

        try {
            queue.put(new DelayedWorker(2000,"This is the first message..."));
            queue.put(new DelayedWorker(1500,"This is the second message..."));
            queue.put(new DelayedWorker(3000,"This is the third message..."));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        while(!queue.isEmpty()) {
            try {
                System.out.println((queue.take()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}