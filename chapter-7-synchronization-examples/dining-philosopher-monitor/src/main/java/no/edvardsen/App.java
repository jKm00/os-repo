package no.edvardsen;

import java.util.ArrayList;
import java.util.List;

/**
 * Dining philosophers. Not finished, can result in starvation with this version
 * @version 0.1
 */
public class App 
{
    private final int PHILOSOPHER_COUNT = 5;

    private List<Chopstick> chopsticks;
    private List<Philosopher> philosophers;

    public static void main( String[] args )
    {
        System.out.println( "Starting app..." );
        App app = new App();

        System.out.println("Initializing...");
        app.initialize();

    }

    private void initialize() {
        this.chopsticks = new ArrayList<>();
        this.philosophers = new ArrayList<>();
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            this.chopsticks.add(new Chopstick());
            this.philosophers.add(new Philosopher(i, this));
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    public Chopstick getChopstick(int id) {
        return this.chopsticks.get(id);
    }
}
