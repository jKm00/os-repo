import java.util.Random;

public class Philosopher implements Runnable {

    private Object leftChopstick;
    private Object rightChopstick;
    private State state;

    private final int MAX_SLEEP_TIME = 10;

    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    public Philosopher(Object leftChopstick, Object rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.state = State.THINKING;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Philosopher is thinking
                this.doAct();
                synchronized (leftChopstick) {
                    this.state = State.HUNGRY;
                    leftChopstick.wait();
                    synchronized (rightChopstick) {
                        rightChopstick.wait();
                        this.state = State.EATING;
                        this.doAct();

                        rightChopstick.notify();
                    }
                    leftChopstick.notify();
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void doAct() throws  InterruptedException {
        if (this.state == State.THINKING) {
            this.printAct("Thinking...");
            Thread.sleep(getRandomNumber(this.MAX_SLEEP_TIME));
        } else if (this.state == State.HUNGRY) {
            this.printAct("Hungry...");
        } else {
            this.printAct("Eating...");
            Thread.sleep(getRandomNumber(this.MAX_SLEEP_TIME));
        }
    }

    private void printAct(String act) {
        System.out.println(Thread.currentThread().getName() + " " + act);
    }

    private int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound) * 1000;
    }
}