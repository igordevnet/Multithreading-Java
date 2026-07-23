import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = createArray(100000000);
        int[] nums2 = new int[nums1.length];

        System.arraycopy(nums1, 0, nums2, 0, nums1.length);

        int numOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Num of available threads: " + numOfThreads);


        ParallelMergeSort sort = new ParallelMergeSort(nums1);
        ParallelMergeSort parallelSort = new ParallelMergeSort(nums2);

        long startTime1 = System.currentTimeMillis();
        sort.sort();
        long endTime1 = System.currentTimeMillis();

        System.out.println();

        long startTime2 = System.currentTimeMillis();
        parallelSort.parallelSort(numOfThreads);
        long endTime2 = System.currentTimeMillis();

        System.out.println();

        System.out.printf("Time taken with parallel sort: %6d ms\n", endTime2 - startTime2);
        System.out.printf("Time taken with sequential sort: %6d ms\n", endTime1 - startTime1);
    }

    private static int[] createArray(int n) {

        Random random = new Random();

        int[] a = new int[n];

        for(var i=0;i<n;i++)
            a[i] = random.nextInt(n);

        return a;
    }
}