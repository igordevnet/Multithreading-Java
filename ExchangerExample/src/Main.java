import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        var exchanger = new Exchanger<Integer>();

        new Thread(new FirstWorker(exchanger)).start();
        new Thread(new SecondWorker(exchanger)).start();

    }
}