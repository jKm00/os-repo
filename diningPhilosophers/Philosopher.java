package diningPhilosophers;

public class Philosopher {
  private boolean leftChopstick;
  private boolean rightChopstick;
  private State state;

  enum State {
    THINKING,
    HUNGRY,
    EATING
  }

  public Philosopher() {
    this.leftChopstick = false;
    this.rightChopstick = false;
    this.state = State.THINKING;
  }

  public State getState() {
    return this.state;
  }
}