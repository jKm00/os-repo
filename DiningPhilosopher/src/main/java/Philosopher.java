import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Philosopher extends Thread {

    private int id;
    private boolean leftStick;
    private boolean rightStick;
    private State currentState;
    private Chopstick[] chopsticks;

    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    public Philosopher(int id, Chopstick[] chopsticks) {
        this.id = id;
        this.leftStick = false;
        this.rightStick = false;
        this.currentState = State.THINKING;
        this.chopsticks = chopsticks;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    @Override
    public void run() {
        int UPPER_SLEEP_BOUND = 10;

        System.out.println("Philosopher " + this.id + ": Started thread");
        while (true) {
            try {
                // Simulate the philosopher to think for a random amount of seconds
                int sleepTime = this.getRandomSleepTime(UPPER_SLEEP_BOUND);
                this.sleep(sleepTime);
                // The philosopher is now hungry
                this.currentState = State.HUNGRY;
                // He needs to wait for the chopsticks to be available
                Chopstick cs1 = this.chopsticks[this.id];
                Chopstick cs2 = this.chopsticks[(this.id + 1) % 5];
                cs1.wait();
                System.out.println("Philosopher " + this.id + ": Picked up chopstick " + cs1.getId());
                cs2.wait();
                System.out.println("Philosopher " + this.id + ": Picked up chopstick " + cs2.getId());
                // Philosopher is now eating
                this.currentState = State.EATING;
                // The philosopher eats for a random amount of seconds
                int eatTime = this.getRandomSleepTime(UPPER_SLEEP_BOUND);
                this.sleep(eatTime);
                // He puts down his chopsticks so others can use them
                cs1.notify();
                System.out.println("Philosopher " + this.id + ": Put down chopstick " + cs1.getId());
                cs2.notify();
                System.out.println("Philosopher " + this.id + ": Put down chopstick " + cs2.getId());
                // The philosopher is now done eating and back to thinking
                this.currentState = State.THINKING;
            } catch (Exception e) {
                System.out.println("Philosopher " + this.id + ": " + e.getMessage());
            }
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + this.id + ": Could not sleep");
        }
        System.out.println("Philosopher " + this.id + ": Slept for " + time + " milliseconds");
    }

    /**
     * Returns a random sleep time in seconds as milliseconds.
     * The number is generated from 0 and the upperbound given as param
     *
     * @param upperbound the max seconds for the sleep timer
     * @return a value for seconds to sleep in milliseconds. (Eg: 1 seconds
     * will be returned as 1000)
     */
    private int getRandomSleepTime(int upperbound) {
        Random rand = new Random();
        int random = rand.nextInt(upperbound);
        return random * 1000;
    }
}
