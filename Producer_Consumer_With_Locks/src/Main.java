public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();

        var td1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.Producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var td2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.Consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        td1.start();
        td2.start();

        try {
            td1.join();
            td2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}