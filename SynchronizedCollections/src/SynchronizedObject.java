import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedObject implements Runnable {

    private final List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
//    private final List<Integer> nums = new ArrayList<>();


    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            nums.add(i);
        }
    }

    public String getSize() {
        var size = nums.size();
        return "Array's size is: " + size;
    }
}
