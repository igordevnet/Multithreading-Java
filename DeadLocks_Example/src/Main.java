public class Main {

    public static void main(String[] args) {
        var deadLock = new DeadLock();

       new Thread(deadLock::worker1, "Worker1").start();
       new Thread(deadLock::worker2, "Worker2").start();
    }
}