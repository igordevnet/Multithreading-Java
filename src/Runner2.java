public class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i=0; i<10;++i) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Thread 2: " + i);
        }
    }
}
