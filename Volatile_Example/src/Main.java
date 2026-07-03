public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        var td1 = new Thread(worker, "Worker");

        td1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

        worker.setTerminated();
        System.out.println(td1.getName() + " was stopped by Main Thread.");
    }
}