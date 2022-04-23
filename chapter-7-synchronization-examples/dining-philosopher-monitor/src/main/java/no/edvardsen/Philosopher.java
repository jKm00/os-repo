package no.edvardsen;

import java.util.Random;

public class Philosopher extends Thread {
  private final Random RAND = new Random();
  private final int UPPER_BOUND = 10;

  private int id;
  private App app;

  public Philosopher(int id, App app) {
    this.id = id;
    this.app = app;
  }

  public void run() {
    while (true) {
      try {
        System.out.println("Philosopher " + id + ": Thinking...");
        sleep(randomTime());

        System.out.println("Philosopher " + id + ": Hungry...");
        Chopstick leftChopstick = app.getChopstick(id);
        leftChopstick.pickUp();
        Chopstick rightChopstick = app.getChopstick((id + 1) % 5);
        rightChopstick.pickUp();

        System.out.println("Philosopher " + id + ": Eating...");
        sleep(randomTime());

        leftChopstick.putDown();
        rightChopstick.putDown();
      } catch (Exception e) {}
    }
  }

  private int randomTime() {
    return this.RAND.nextInt(UPPER_BOUND) * 1000;
  }
}