package no.edvardsen;

import java.util.Random;

public class Philosopher extends Thread {
  private int id;
  private App app;
  private boolean hungry;

  private final Random rand = new Random();
  private final int UPPER_BOUND_SLEEP = 10;

  public Philosopher(int id, App app) {
    this.id = id;
    this.app = app;
    this.hungry = false;
  }

  public void run() {
    while (true) {
      try {

        System.out.println("Philosopher " + id + ": is thinking");
        sleep(randomTime());
  
        System.out.println("Philosopher " + id + ": hungry, waiting for both chopsticks");
        this.hungry = true;
        while (hungry) {
          if (app.checkLeft(id) && app.checkRight(id)) {
            app.waitMutex();
            app.pickupLeft(id);
            app.pickupRight(id);
            app.signalMutex();
  
            System.out.println("Philosopher " + id + ": got both chopsticks, is now eating");
            sleep(randomTime());
      
            System.out.println("Philosopher " + id + ": done eating, putting down both chopsticks");
            app.putdownLeft(id);
            app.putdownRight(id);
            this.hungry = false;
          }
        }
  
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } 
    }

  private int randomTime() {
    return rand.nextInt(UPPER_BOUND_SLEEP) * 1000;
  }
}
