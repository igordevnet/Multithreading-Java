import java.util.concurrent.RecursiveTask;

public class ParallelMaxTask extends RecursiveTask<Long> {

    private final long[] nums;
    private final int lowIndex;
    private final int highIndex;
    private final int threshold;

    public ParallelMaxTask(long[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
        this.threshold = Constants.THRESHOLD;
    }


    @Override
    protected Long compute() {
        if((highIndex - lowIndex) < threshold) {
            return sequentialMaxFinding();
        }

        System.out.println("Running parallel approach...");

        int middleIndex = (lowIndex + highIndex) / 2;

        ParallelMaxTask leftHalf = new ParallelMaxTask(nums, lowIndex, middleIndex);
        ParallelMaxTask rightHalf = new ParallelMaxTask(nums, (middleIndex + 1), highIndex);

        leftHalf.fork();

        long rightResult = rightHalf.compute();
        long leftResult = leftHalf.join();

        return Math.max(leftResult, rightResult);
    }

    private Long sequentialMaxFinding() {

        System.out.println("Running sequential approach...");

        var max = nums[lowIndex];

        for(var i=(lowIndex+1);i<=highIndex;i++)
            if(nums[i] > max)
                max = nums[i];

        return max;
    }
}
