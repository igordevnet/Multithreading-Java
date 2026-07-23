import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var nums = createArray(12);
        var numOfThreads = Runtime.getRuntime().availableProcessors();

        for(var i=0;i<nums.length;i++)
            System.out.print(nums[i] + " ");

        ParallelSum parallelSum = new ParallelSum(numOfThreads);
        System.out.println("\nResult: " + parallelSum.sum(nums));
    }

    private static int[] createArray(int n) {

        Random random = new Random();

        int[] a = new int[n];

        for(var i=0;i<n;i++)
            a[i] = random.nextInt(n);

        return a;
    }
}