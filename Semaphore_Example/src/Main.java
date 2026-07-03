import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0;i<12;i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    SemaphoreExample.INSTANCE.download();
                }
            });
        }

    }
}