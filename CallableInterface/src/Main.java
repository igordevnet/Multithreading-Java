import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> futureList = new ArrayList<>();

        for(var i=0;i<20;i++) {
            Future<String> futures = executor.submit(new Processor((i+1)));
            futureList.add(futures);
        }

        for (Future<String> future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}