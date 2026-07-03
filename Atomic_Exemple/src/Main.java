public class Main {
    public static void main(String[] args) {

        var atomic = new AtomicIntegerExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomic.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomic.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var result = atomic.getValue();

        System.out.println("Result: " + result);
    }
}