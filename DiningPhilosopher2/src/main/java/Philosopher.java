import java.util.Random;

public class Philosopher implements Runnable {

    private Object leftChopstick;
    private Object rightChopstick;

    private final int MAX_SLEEP_TIME = 10;

    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    public Philosopher(Object leftChopstick, Object rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Philosopher is thinking
                this.act(": Thinking...");
                synchronized (leftChopstick) {
                    act(": Picked up left chopstick");
                    synchronized (rightChopstick) {
                        act(": Picked up right chopstick");

                        act(": Put down right chopstick");
                    }
                    act(": Put down left chopstick. Back to thinking...");
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void act(String action) throws  InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(getRandomNumber(this.MAX_SLEEP_TIME));
    }

    private int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound) * 1000;
    }
}