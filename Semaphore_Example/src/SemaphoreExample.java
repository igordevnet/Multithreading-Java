import java.util.concurrent.Semaphore;

enum SemaphoreExample {
    INSTANCE;

    private final Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            System.out.println("Acquiring permit... Remaining: " + semaphore.availablePermits());
            downloadFromTheInternet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void downloadFromTheInternet() throws InterruptedException{
        System.out.println("Downloading data from the internet...");
        Thread.sleep(3000);
    }
}
