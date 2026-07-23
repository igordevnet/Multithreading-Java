public class SumWorker extends Thread {

    private final int[] nums;
    private final int low;
    private final int high;
    private int partialSum;

    public SumWorker(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = Math.min(high, nums.length);
    }

    @Override
    public void run() {
        partialSum = 0;

        for(int i=low;i<high;i++)
            partialSum += nums[i];
    }

    public int getPartialSum() {
        return partialSum;
    }
}
