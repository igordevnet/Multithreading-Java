import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=0;i<100;i++) {
            executor.execute(new Task(i));
        }

        executor.shutdown();

        try {
            if(!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdown();
        }

    }
}