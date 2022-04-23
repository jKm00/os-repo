package no.edvardsen;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App extends Thread
{
    private final int N = 2;
    private final Random rand = new Random();

    private int mutex;
    private int empty;
    private int full;

    public static void main( String[] args )
    {
        App app = new App();
        app.initialize();

        App thread = new App();
        thread.start();

        System.out.println("Started threads");
    }

    private void initialize() {
        this.mutex = 1;
        this.empty = this.N;
        this.full = 0;
    }

    private void myWait() {
        while (mutex <= 0 || empty <= 0) {
            System.out.println("Waiting...");
        }
        this.mutex = 0;
        this.empty--;
        this.full++;
    }

    private void mySignal() {
        this.empty++;
        this.full--;
        this.mutex = 1;
    }

    public void run() {
        while(true) {
            myWait();
            System.out.println("" + Thread.currentThread().getId() + "Doing some processing...");
            try {
                sleep(this.getNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySignal();
        }
    }

    public int getNumber() {
        return this.rand.nextInt(10) * 1000;
    }
}
