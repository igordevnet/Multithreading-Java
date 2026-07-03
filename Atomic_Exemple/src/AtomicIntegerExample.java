import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        for (var i=0;i<10000;i++) {
            count.getAndIncrement();
        }
    }

    public Integer getValue() {
        return count.get();
    }
}
