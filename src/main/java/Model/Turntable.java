package model;

public class Turntable extends Buffer implements Runnable {

    private Buffer[] slots;
    private boolean stop = false;
    private int io;

    public Turntable(Buffer a, Buffer b, Buffer c , Buffer d, int io, Clock clock, String name) {
        super(1,clock,name);
        slots = new Buffer[4];
        slots[0] = a;
        slots[1] = b;
        slots[2] = c;
        slots[3] = d;
        this.io = io;
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
        int [] io = getBits(this.io,4);

        if(slots[i] != null) {
            if(body[0] == null && io[i] == 1) {
                if(slots[i].available > 0) {
                    body[0] = slots[i].extract();
//                    System.out.println(name + " direction: input " + i + " output? " + io[i]);
                }
            } else {
                if(body[0] != null && io[i] == 0) {
                    if(slots[i].isSack()) {
                        if(slots[i].category == body[0].getGroup()) {
                            slots[i].insert(body[0]);
                            body[0] = null;
                        }
//                    System.out.println(name + " direction: output " + i + " inputt? " + io[i]);
                    } else {
                        slots[i].insert(body[0]);
                        body[0] = null;
                    }
                }
            }
        }
        return true;
    }

    public void requestStop() {
        stop = true;
    }

    public static int[] getBits(int v, int num) {
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = getBit(v, num - i - 1);
        }
        return arr;
    }

    public static int getBit(int v, int i) {
        return v >> i & 1;
    }
}
