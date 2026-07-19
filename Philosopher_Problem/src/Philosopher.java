import java.util.Random;

public class Philosopher implements Runnable{

    private int id;
    private volatile boolean full;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Random random;
    private int eatingCounter;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!full) {
                think();

                if(leftChopstick.pickUp(this, State.LEFT)) {
                    if(rightChopstick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }
                    
                    leftChopstick.putDown(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void think() throws InterruptedException {
        System.out.println(this + " is thinking...");

        Thread.sleep(random.nextInt(1000));
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " is eating...");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public void setfull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return this.full;
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public int getEatingCounter() {
        return this.eatingCounter;
    }
}
