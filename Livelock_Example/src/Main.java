public class Main {
    public static void main(String[] args) {

        LivelockExample livelock = new LivelockExample();

        new Thread(livelock::worker1, "worker1").start();
        new Thread(livelock::worker2, "worker2").start();
    }
}