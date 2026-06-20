public class Main
{
    public static void main(String[] args) {
        Thread daemonT = DaemonThread.build();
        Thread normalT = NormalThread.build();

        daemonT.start();
        normalT.start();
    }
}
