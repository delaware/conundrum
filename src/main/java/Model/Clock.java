package model;

public class Clock extends Thread {

    static int time = 0;
    static int endOfDay = 5;
    private boolean stop = false;

    public void run() {
        while(!stop) {
            inc();
            try {
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

    public void requestStop() {
        stop = true;
    }
}
