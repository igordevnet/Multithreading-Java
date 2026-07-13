import java.util.concurrent.ConcurrentMap;

public class FirstWorker implements Runnable {

    private final ConcurrentMap<String, Integer> map;

    public FirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("A", 10);
            Thread.sleep(1000);
            map.put("B", 11);
            map.put("C", 9);
            map.put("D", 101);
            Thread.sleep(500);
            map.put("E", 30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
