import java.util.concurrent.Callable;

public class Processor implements Callable<String> {

    private final int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "This id: " + id;
    }
}
