import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<String, Integer>();

        new Thread(new FirstWorker(map)).start();
        new Thread(new SecondWorker(map)).start();
    }
}