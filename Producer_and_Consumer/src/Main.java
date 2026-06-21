public class Main {
    public static void main(String[] args) {
        var buffer = new SharedBuffer();

        var t1 = new Thread(() -> {
            while(true){
                try {
                    buffer.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var t2 = new Thread(() -> {
            while(true) {
                try {
                    buffer.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}