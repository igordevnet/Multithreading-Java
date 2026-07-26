import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        int bound = Constants.BOUND;
        var nums = createArray(bound);
        var numOfThreads = Runtime.getRuntime().availableProcessors();

        for(Long num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        ParallelMaxTask task = new ParallelMaxTask(nums, 0, nums.length -1);

        try(ForkJoinPool pool = new ForkJoinPool(numOfThreads)) {
            System.out.println("Max number: " + pool.invoke(task));
        }
    }

    private static long[] createArray(int n) {

        Random random = new Random();

        long[] a = new long[n];

        for(var i=0;i<n;i++)
            a[i] = random.nextLong(n);

        return a;
    }
}