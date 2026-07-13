import java.util.concurrent.ConcurrentMap;

public class SecondWorker implements Runnable {

    private final ConcurrentMap<String, Integer> map;

    public SecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("D"));
            System.out.println(map.get("B"));
            Thread.sleep(500);
            System.out.println(map.get("E"));
            System.out.println(map.get("C"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
