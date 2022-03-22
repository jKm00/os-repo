public class DiningPhilosopher {
    private boolean[] chopsticks;

    public void initializePhilosophers() {
        this.chopsticks = new boolean[5];
    }

    public void runSimulation() {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("Started thread for philosopher 1");
            }
        };
        thread.start();
    }
}
