import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(50);
        ExecutorService service = Executors.newFixedThreadPool(2);

        for(var i=0;i<50;i++){
            service.execute(new Worker((i+1), latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
        System.out.println("Worker was stopped successfully");
    }
}