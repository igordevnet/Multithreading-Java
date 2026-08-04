public class VirtualTask {

    public static void run()  {
        System.out.println("Starting virtual thread with id: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing virtual thread with id: " + Thread.currentThread().getName());
    }
}
