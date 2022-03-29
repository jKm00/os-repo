import java.util.Random;

public class Chopstick {
    private int id;
    private boolean available;

    public Chopstick(int id) {
        this.id = id;
        this.available = true;
    }

    /**
     * True if chopstick is available, false otherwise
     * @return
     */
    public boolean isAvailable() {
        return this.available;
    }

    public int getId() {
        return this.id;
    }

    public void pickUp() {
        this.available = false;
    }

    public void putDown() {
        this.available = true;
    }
}