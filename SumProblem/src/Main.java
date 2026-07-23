import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums = createArray(100);

        SequentialSum sequentialSum = new SequentialSum(nums);
        sequentialSum.sumUp();
        sequentialSum.printArrayAndResult();
    }

    private static int[] createArray(int n) {

        Random random = new Random();

        int[] a = new int[n];

        for(var i=0;i<n;i++)
            a[i] = random.nextInt(n);

        return a;
    }
}