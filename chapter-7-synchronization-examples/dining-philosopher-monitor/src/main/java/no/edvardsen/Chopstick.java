package no.edvardsen;

public class Chopstick {
  private boolean available;

  public Chopstick() {
    this.available = true;
  }

  public synchronized void pickUp() {
    while (!this.isAvailable()) {
      try {
        wait();
      } catch (Exception e) {}
    }
    this.available = false;

    notify();
  }

  public synchronized void putDown() {
    this.available = true;
  }

  public boolean isAvailable() {
    return this.available;
  }
}