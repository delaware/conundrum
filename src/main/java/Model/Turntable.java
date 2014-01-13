package model;

import java.util.Objects;

public class Turntable extends Thread {

    private Object[] slots;
    private boolean stop = false;
    Clock c;

    public Turntable(Object a, Object b, Object c , Object d, Clock clock) {
        slots = new Object[4];
        slots[0] = a;
        slots[1] = b;
        slots[2] = c;
        slots[3] = d;
        this.c = clock;
    }

    public void run() {
        while(!stop){
            turn();
            try {
                sleep( (int) (Math.random() * 1000));
            }
            catch (InterruptedException ex) {}
        }
    }

    public boolean turn() {
        int i = c.time%4;
        System.out.println("Richtung: " + i++);
        return true;
    }

    public void requestStop() {
        stop = true;
    }
}
