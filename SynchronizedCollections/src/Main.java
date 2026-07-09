public class Main {
    public static void main(String[] args) {

        var synchronizedObj = new SynchronizedObject();

        var thread1 = new Thread(synchronizedObj);
        var thread2 = new Thread(synchronizedObj);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

        System.out.println(synchronizedObj.getSize());
    }
}