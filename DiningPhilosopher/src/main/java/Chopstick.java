import java.util.Random;

public class Chopstick {
    private int id;
    private boolean available;

    public Chopstick(int id) {
        this.id = id;
        this.available = true;
    }

    public synchronized long pickUp(int philosopherId) {
        System.out.println("Philosopher " + philosopherId + ": Picked up chopstick " + this.id);
        return 1;
    }

    public int getId() {
        return this.id;
    }
}
