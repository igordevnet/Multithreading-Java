import java.util.concurrent.Exchanger;

public class SecondWorker implements Runnable {

    private final Exchanger<Integer> exchanger;
    private int counter;

    public SecondWorker(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(true) {
            counter--;
            System.out.println("SecondThread decremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println("SecondThread got the counter: " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
