public class NormalThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Running the Normal Thread...");
    }

    public static NormalThread build() {
        var nThread = new NormalThread();

        System.out.println("Thread created, is daemon? " + nThread.isDaemon());

        return nThread;
    }
}

