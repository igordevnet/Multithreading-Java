import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        var numOfThreads = Runtime.getRuntime().availableProcessors();
        Random random = new Random();

        int bound = Constants.BOUND;

        var range = random.nextInt(bound);

        FibonacciWorker worker = new FibonacciWorker(range);

        try (ForkJoinPool pool = new ForkJoinPool(numOfThreads)) {
            System.out.println("Random range: " + range);
            System.out.println("Result: " + pool.invoke(worker));
        }
    }
}