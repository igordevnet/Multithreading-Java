public class Process {

    public void produce() throws InterruptedException {

        synchronized (this) {
            System.out.println("Running the produce method");
            wait();
            System.out.println("Running it again ");
        }
    }

    public void consume() throws InterruptedException {

        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Running the consume method");
            notify();
            System.out.println("After notifying the other thread");
        }
    }
}
