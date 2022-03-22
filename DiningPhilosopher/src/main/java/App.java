public class App {
    public static void main(String[] args) {
        DiningPhilosopher diningPhilosopher = new DiningPhilosopher();
        diningPhilosopher.initializePhilosophers();
        diningPhilosopher.runSimulation();
    }
}
