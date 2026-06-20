public class Main
{
    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = () -> {
            for (int i=0; i<10;++i) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Thread 3: " + i);
            }
        };

        Runnable r2 = () -> {
            for (int i=0; i<10;++i) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Thread 4: " + i);
            }
        };

        var t1 = new Thread(new Runner1());
        var t2 = new Thread(new Runner2());
        var t3 = new Thread(r1);
        var t4 = new Thread(r2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        for (Thread t : Thread.getAllStackTraces().keySet()) {
            System.out.println("The thread's name: " + t.getName() + " State: " + t.getState());
        }

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Finished execution.");

    }
}

