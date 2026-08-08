public class RestQuery {

    public static String run()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Something REST";
    }
}
