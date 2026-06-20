public class DaemonThread extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Running the Daemon Thread...");
        }
    }

    public static DaemonThread build() {
        var dThread = new DaemonThread();
        dThread.setDaemon(true);

        System.out.println("Thread created, is daemon? " + dThread.isDaemon());

        return dThread;
    }
}
