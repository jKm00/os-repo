/**
 * Represents the table where all the philosophers are sitting.
 * They are either thinking, hungry or eating.
 */
public class DiningTable {
    private Philosopher[] philosophers;

    public void initialize() {
        this.philosophers = new Philosopher[5];
    }

    public void runSimulation() {
        Thread philosopher0 = new Philosopher(0);
        Thread philosopher1 = new Philosopher(1);
        Thread philosopher2 = new Philosopher(2);
        Thread philosopher3 = new Philosopher(3);
        Thread philosopher4 = new Philosopher(4);

        philosopher0.start();
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }

    public static void main(String[] args) {
        DiningTable diningTable = new DiningTable();
        diningTable.initialize();
        diningTable.runSimulation();
    }
}
