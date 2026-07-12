import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedWorker implements Delayed {


    private final long duration;
    private final String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert((duration - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {

        if (duration < ((DelayedWorker) delayed).getDuration()) {
            return -1;
        }
        if (duration > ((DelayedWorker) delayed).getDuration()) {
            return 1;
        }

        return 0;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "DelayedWorker [" +
                "message='" + message + '\'' +
                ", duration=" + duration +
                ']';
    }
}
