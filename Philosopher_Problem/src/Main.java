import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int numberChopsticks = Constants.NUMBER_OF_CHOPSTICKS;
        int numberPhilosophers = Constants.NUMBER_OF_PHILOSOPHERS;

        ExecutorService service = null;
        Philosopher[] philosophers = null;
        Chopstick[] chopsticks = null;

        try {
            philosophers = new Philosopher[numberPhilosophers];
            chopsticks = new Chopstick[numberChopsticks];

            for(int i=0;i<numberChopsticks; i++) {
                chopsticks[i] = new Chopstick(i);
            }

            service = Executors.newFixedThreadPool(numberPhilosophers);

            for(int i=0;i<numberPhilosophers; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1)%numberPhilosophers]);
                service.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            service.shutdown();

            for(Philosopher philosopher : philosophers) {
                philosopher.setfull(true);
            }

        } finally {
            service.shutdown();

            while(!service.isTerminated()) {
                Thread.sleep(1000);

                for(Philosopher philosopher : philosophers) {
                    System.out.println(philosopher + " eat #"+philosopher.getEatingCounter() + " times");
                }
            }
        }
    }
}