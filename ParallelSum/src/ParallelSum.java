public class ParallelSum {

    private final int numOfThreads;
    private final SumWorker[] sumWorkers;

    public ParallelSum(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.sumWorkers = new SumWorker[numOfThreads];
    }

    public int sum(int[] nums) {

        int size = (int) Math.ceil(nums.length * 1.0 / numOfThreads);

        for(var i=0;i<numOfThreads;i++) {
            sumWorkers[i] = new SumWorker(nums, i * size, (i + 1) * size);
            sumWorkers[i].start();
        }

        try {
            for(Thread worker : sumWorkers)
                worker.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = 0;

        for(SumWorker worker : sumWorkers)
            result += worker.getPartialSum();

        return result;
    }
}
