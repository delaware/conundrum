package model;

public class Clock implements Runnable {

    static int time = 0;

    public void run() {
        while(true) {
            try {
                inc();
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public static synchronized void inc() {
        time++;
    }

    public static synchronized int time() {
        return time;
    }
}
