import java.util.concurrent.Exchanger;

public class FirstWorker implements Runnable {

    private final Exchanger<Integer> exchanger;
    private int counter;

    public FirstWorker(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(true) {
            counter++;
            System.out.println("FirstThread incremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println("FirstThread got the counter: " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
