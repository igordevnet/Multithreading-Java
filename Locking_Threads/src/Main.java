import java.time.LocalDateTime;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        var initTime = LocalDateTime.now();

        var thread = new ThreadToSynchronize();
        thread.execute();

        var finalTime = LocalDateTime.now();
        long runTime = Duration.between(initTime, finalTime).toMillis();

        System.out.println("\nTest finished! ms: " + runTime);
    }

}
