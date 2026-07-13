import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArray  {

    private final List<Integer> list;

    public ConcurrentArray() {
        this.list = new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    }

    public void simulate() {
        new Thread(new WriteTask(list)).start();
        new Thread(new WriteTask(list)).start();
        new Thread(new WriteTask(list)).start();
        new Thread(new ReadTask(list)).start();
    }
}
