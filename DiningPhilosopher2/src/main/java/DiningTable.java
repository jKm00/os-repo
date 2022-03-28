import java.util.ArrayList;

/**
 * Represents the table where all the philosophers are sitting.
 * They are either thinking, hungry or eating.
 */
public class DiningTable {
    private Chopstick[] chopsticks;
    private ArrayList<Philosopher> philosophers;

    public void initialize() {
        this.philosophers = new ArrayList<>();
        this.chopsticks = new Chopstick[]{new Chopstick(0), new Chopstick(1), new Chopstick(2), new Chopstick(3), new Chopstick(4)};
    }

    public void runSimulation() {
        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(i, this.chopsticks);
            this.philosophers.add(philosopher);
            philosopher.start();
        }
    }

    public static void main(String[] args) {
        DiningTable diningTable = new DiningTable();
        diningTable.initialize();
        diningTable.runSimulation();
    }

    /**
     * Returns the next philosopher of the one who called this
     * method.
     * @param id the id of the current philosopher that wants
     *           to get his/her side partner
     * @return the philosopher next to the one who called
     * this method
     */
    public Philosopher getNextPhilosopher(int id) {
        int INCREMENT = 1;
        return this.philosophers.get((id + INCREMENT) % this.philosophers.size());
    }
}