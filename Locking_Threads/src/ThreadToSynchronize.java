public class ThreadToSynchronize {

    private int count1;
    private int count2;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment1(){
        synchronized(lock1) {
            count1++;
        }
    }

    public void increment2(){
        synchronized(lock2) {
            count2++;
        }
    }

    public void execute() {
        Thread t1 = new Thread(() -> {
            for(int i=0; i < 1000; ++i) {
                increment1();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i < 1000; ++i) {
                increment2();
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

        System.out.println("Count1: " + count1);
        System.out.println("Count2: " + count2);
    }
}

