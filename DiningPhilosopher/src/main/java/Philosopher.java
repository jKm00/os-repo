import java.util.Random;

public class Philosopher implements Runnable {

    private Object leftChopstick;
    private Object rightChopstick;

    private final int MAX_SLEEP_TIME = 10;

    public Philosopher(Object leftChopstick, Object rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Philosopher is thinking
                this.thinking();
                // After thinking, the philosopher gets hungry
                this.hungry();
                synchronized (leftChopstick) {
                    this.pickUpLeft();
                    synchronized (rightChopstick) {
                        this.pickUpRight();
                        // Eating
                        this.eating();

                        // When done eating, the philosopher puts down his chopsticks
                        this.putDownLeft();
                    }
                    this.pickUpRight();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void pickUpLeft() {
        System.out.println(Thread.currentThread().getName() + " : Picked up left chopstick");
    }

    private void pickUpRight() {
        System.out.println(Thread.currentThread().getName() + " : Picked up right chopstick");
    }

    private void putDownLeft() {
        System.out.println(Thread.currentThread().getName() + " : Put down left chopstick");
    }

    private void putDownright() {
        System.out.println(Thread.currentThread().getName() + " : Put down right chopstick");
    }

    private void thinking() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " : Thinking...");
        Thread.sleep(getRandomNumber(MAX_SLEEP_TIME));
    }

    private void hungry() {
        System.out.println(Thread.currentThread().getName() + " : Hungry...");
    }

    private void eating() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " : Eating...");
        Thread.sleep(getRandomNumber(MAX_SLEEP_TIME));
    }

    private int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound) * 1000;
    }
}