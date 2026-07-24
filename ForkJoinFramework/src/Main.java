import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        var array = createArray(10);

        IntWorker worker = new IntWorker(array, 0, array.length);

        try (ForkJoinPool pool = new ForkJoinPool(numOfThreads)) {
            pool.invoke(worker);
        }
    }

    private static int[] createArray(int n) {

        Random random = new Random();

        int[] a = new int[n];

        for(var i=0;i<n;i++)
            a[i] = random.nextInt(n);

        return a;
    }
}