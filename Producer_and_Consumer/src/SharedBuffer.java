import java.util.LinkedList;
import java.util.List;

public class SharedBuffer {

    private List<Integer> buffer = new LinkedList<>();

    private int capacity = 5;

    public synchronized void producer() throws InterruptedException {
        if(buffer.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait();
        }

        for(var i=0; i < capacity; ++i) {
            buffer.add(i);
            Thread.sleep(500);

            System.out.println("Added value: " + i);
        }

        notify();
    }

    public synchronized void consumer() throws InterruptedException {
        if(buffer.size() < capacity) {
            System.out.println("Buffer not full yet, consumer waiting...");
            wait();
        }

        while(!buffer.isEmpty()) {
            int item = buffer.removeFirst();
            Thread.sleep(500);

            System.out.println("Item " + item + " removed successfully!" );
        }

        notify();
    }
}
