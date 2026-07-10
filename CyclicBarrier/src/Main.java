import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("All task have been finished.");
            }
        });

        for(var i=0;i<2;i++) {
            service.execute(new BarrierWorker((i+1), barrier));
        }

        service.shutdown();
    }
}