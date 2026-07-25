import java.util.concurrent.RecursiveTask;

public class FibonacciWorker extends RecursiveTask<Integer> {

    private final int n;
    private final int THRESHOLD = Constants.THRESHOLD;

    public FibonacciWorker(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if(n<=1) {
            return n;
        }

        if (n < THRESHOLD) {
            return sequentialFib(n);
        }

        var firstHalf = new FibonacciWorker(n-1);
        var secondHalf = new FibonacciWorker(n-2);

        firstHalf.fork();

        var subResult = secondHalf.compute();
        subResult += firstHalf.join();

        return subResult;
    }

    private int sequentialFib(int n) {
        if (n <= 1)
            return n;

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
