package no.edvardsen;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    private int[] chopsticks = new int[5];
    private int mutex;
    public static void main( String[] args )
    {
        System.out.println("Starting app...");
        App app = new App();
        app.initialize(app);
    }

    private void initialize(App app) {
        this.mutex = 1;

        ArrayList<Philosopher> philosophers = new ArrayList<>();

        System.out.println("Initializing...");
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = 1;
        }

        System.out.println("Starting threads...");
        for (int i = 0; i < chopsticks.length; i++) {
            philosophers.add(new Philosopher(i, app));
            philosophers.get(i).start();
        }
    }

    /**
     * Checks the left chopstick of the philosopher that called this function
     * @param id of the philosopher
     * @return true if its available
     */
    public boolean checkLeft(int id) {
        return chopsticks[id] == 1;
    }

    /**
     * Checks the right chopstick of the philosopher that called this function
     * @param id of the philosopher
     * @return true if its available
     */
    public boolean checkRight(int id) {
        return chopsticks[(id + 1) % 5] == 1;
    }

    /**
     * Pick up the left chopstick of the philosopher that called this function
     * @param id of the philosopher
     */
    public void pickupLeft(int id) {
        chopsticks[id] = 0;
    }

     /**
     * Pick up the right chopstick of the philosopher that called this function
     * @param id of the philosopher
     */
    public void pickupRight(int id) {
        chopsticks[(id + 1) % 5] = 0;
    }

     /**
     * Put down the left chopstick of the philosopher that called this function
     * @param id of the philosopher
     */
    public void putdownLeft(int id) {
        chopsticks[id] = 1;
    }

     /**
     * Put down the right chopstick of the philosopher that called this function
     * @param id of the philosopher
     */
    public void putdownRight(int id) {
        chopsticks[(id + 1) % 5] = 1;
    }

     /**
     * Called to make sure only the philosopher that called this function
     * is picking up chopstick. (the critical section of a philosopher is run while it has the mutex lock)
     */
    public void waitMutex() {
        while (mutex <= 0) {}
        mutex--;
    }

    /**
     * Called to release the lock when a philosopher is done with its critical section, so other philosophers
     * can run thei critical section
     */
    public void signalMutex() {
        mutex++;
    }
}
