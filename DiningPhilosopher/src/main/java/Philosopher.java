public class Philosopher extends Thread {
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

    public void run() {
        System.out.println("Entered thread with philosopher " + this.id);
    }
}
