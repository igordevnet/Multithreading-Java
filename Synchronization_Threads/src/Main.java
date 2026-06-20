public class Main {

    private static int count;

    public synchronized static void increment() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=0; i < 1000; ++i) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i < 1000; ++i) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Count: " + count);
    }

}

