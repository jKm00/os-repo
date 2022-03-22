package diningPhilosophers;

/**
 * Represents a philosopher. A philosopher can be thinking, hungry or eating.
 * To be able to eat, the philosopher needs to chopsticks. When hes hungry
 * he wants to eat but not enough chopsticks are available.
 */
public class Philosopher {
  private boolean leftChopstick;
  private boolean rightChopstick;
  private State state;

  enum State {
    THINKING,
    HUNGRY,
    EATING
  }

  /**
   * Initializes a philosopher
   */
  public Philosopher() {
    this.leftChopstick = false;
    this.rightChopstick = false;
    this.state = State.THINKING;
  }

  /**
   * Returns the current state of the philosopher
   * @return the currnet state of the philosopher
   */
  public State getState() {
    return this.state;
  }

  /**
   * Sets the state if a philosopher. The state can be THINKING; HUNGRY or EATING
   * @param newState the state to set
   */
  public void setState(State newState) {
    if (newState == State.THINKING || newState == State.HUNGRY) {
      this.leftChopstick = false;
      this.rightChopstick = false;
    } else {
      this.leftChopstick = true;
      this.rightChopstick = true;
    }
    this.state = newState;
  }
}