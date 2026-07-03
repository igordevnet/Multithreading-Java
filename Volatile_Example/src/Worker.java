public class Worker implements Runnable {

    private volatile boolean terminated;

    @Override
    public void run() {
        while (!terminated) {
            System.out.println("Processing data in the worker...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }

    public void setTerminated() {
        terminated = true;
    }
}
