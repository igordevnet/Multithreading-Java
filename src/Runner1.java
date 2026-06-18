public class Runner1 extends Thread {

    @Override
    public void run() {
        for (int i=0; i<10;++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("Thread 1: " + i);
        }
    }
}

