import java.util.concurrent.RecursiveAction;

public class IntWorker extends RecursiveAction {

    private final int[] nums;
    private final int high;
    private final int low;

    public IntWorker(int[] nums, int low, int high) {
        this.nums = nums;
        this.high = Math.min(high, (nums.length - 1));
        this.low = low;
    }

    @Override
    protected void compute() {
        if (low>=high) {
            long actualThreadId = Thread.currentThread().threadId();
            System.out.printf("Number: %d, processed by thread id: %d%n", nums[low], actualThreadId);
        } else {
            int middle = (low+high) / 2;

            System.out.printf("Array chunk [%d to %d] too large, splitting at %d...%n", low, high, middle);

            IntWorker leftWorker = new IntWorker(nums, low, middle);

            IntWorker rightWorker = new IntWorker(nums, middle + 1, high);

            invokeAll(leftWorker, rightWorker);
        }
    }
}