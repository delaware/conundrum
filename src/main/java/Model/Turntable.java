package model;

import java.util.Objects;

public class Turntable extends Buffer implements Runnable {

    private Buffer[] slots;
    private boolean stop = false;

    public Turntable(Buffer a, Buffer b, Buffer c , Buffer d, Clock clock, String name) {
        super(1,clock,name,false);
        slots = new Buffer[4];
        slots[0] = a;
        slots[1] = b;
        slots[2] = c;
        slots[3] = d;
    }

    public void run() {
        while(!stop){
            turn();
            try {
                Thread.sleep((int) (Math.random() * 1000));
            }
            catch (InterruptedException ex) {}
        }
    }

    public boolean turn() {
        int i = c.time%4;
        if(slots[i] != null) {
            if(slots[i].available > 0) {
                if(body[0] == null) {
                    //if(slots[i].isInput()) {
                    System.out.println(name + " direction: input " + i);
                    body[0] = slots[i].extract();
                    //}
                }
            } else {
    //            if(slots[i].available!= 0) {
    //                slots[i].insert(body[0]);
    //            }
//                System.out.println(name + " direction: output " + i);
                body[0] = null;
            }
        }
        return true;
    }

    public void requestStop() {
        stop = true;
    }
}
