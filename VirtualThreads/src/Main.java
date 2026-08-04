public class Main {
    public static void main(String[] args) {
        var factory = Thread.ofVirtual().name("Virtual-", 0).factory();

        var t1 = factory.newThread(VirtualTask::run);
        var t2 = factory.newThread(VirtualTask::run);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            t1.interrupt();
            t2.interrupt();
        }
    }
}