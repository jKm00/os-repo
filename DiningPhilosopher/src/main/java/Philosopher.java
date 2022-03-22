public class Philosopher {
    private int id;
    private boolean leftStick;
    private boolean rightStick;
    private State currentState;

    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    public Philosopher(int id) {
        this.id = id;
        this.leftStick = false;
        this.rightStick = false;
        this.currentState = State.THINKING;
    }

    public boolean getLeftStick() {
        return this.leftStick;
    }

    public boolean getRightStick() {
        return this.rightStick;
    }

    public void setState(State newState) {
        if (newState == State.THINKING || newState == State.HUNGRY) {
            this.layDownSticks();
        } else {
            this.pickUpSticks();
        }
        this.currentState = newState;
    }

    public void pickUpSticks() {
        this.leftStick = true;
        this.rightStick = true;
    }

    public void layDownSticks() {
        this.leftStick = false;
        this.rightStick = false;
    }
}
