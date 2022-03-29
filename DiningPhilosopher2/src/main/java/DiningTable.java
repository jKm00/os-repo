import java.util.ArrayList;

/**
 * Represents the table where all the philosophers are sitting.
 * They are either thinking, hungry or eating.
 */
public class DiningTable {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[5];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];

            // Make sure last philosopher picks up right chopstick first
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
            } else {
                philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}