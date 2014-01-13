package model;

public class Belt {
    private String [] body;
    private int nextIn=0;
    private int nextOut=0;
    private int available;
    Clock c;

    public Belt(int size, Clock c){
        body = new String[size];
        this.c = c;
        available = 0;
    }

    public synchronized void insert(String item){
        while (available == body.length){
            System.out.println("Time " + c.time + ": insert waiting");

            try {
                wait();
            } catch (InterruptedException ex) {
            }

        }
        body[nextIn] = item;
        available = available + 1;
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        nextIn++;
        if(nextIn == body.length){
            nextIn = 0;
        }
        if (available == body.length)
            System.out.println("Time " + c.time + ": buffer full");
        notifyAll();
    }

    public synchronized String extract(){
        String res="";
        while (available == 0){
            System.out.println("Time " + c.time + ": extract waiting");

            try {
                wait();
            } catch (InterruptedException ex) {
            }


        }
        res = body[nextOut];
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        available--;

        if (res==null)
            res = "invalid item";

        nextOut++;
        if (nextOut==body.length)
            nextOut=0;

        if (available == 0)
            System.out.println("Time " + c.time + ": buffer empty");

        notifyAll();
        return res;
    }
}
