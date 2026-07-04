import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=0;i<1000;i++) {
            executor.execute(new Task(i));
        }
    }
}