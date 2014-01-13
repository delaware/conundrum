package model;

public class Belt {
    private Gift [] body;
    private int nextIn=0;
    private int nextOut=0;
    private int available;
    private String name;
    Clock c;

    public Belt(int size, Clock c, String name){
        body = new Gift[size];
        this.c = c;
        this.name = name;
        available = 0;
    }

    public synchronized void insert(Gift item){
        while (available == body.length){
            System.out.println("Time " + c.time + ": " + name + " insert waiting");

            try {
                wait();
                if(item.getWrapper() != null ) { item.getWrapper().incTicksWaited(); }
            }
            catch (InterruptedException ex) {
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
            System.out.println("Time " + c.time + ": " + name + " buffer full");
        notifyAll();
    }

    public synchronized Gift extract(){
        Gift res;
        while (available == 0){
            System.out.println("Time " + c.time + ": " + name + " extract waiting");
            try {
                wait();
            }
            catch (InterruptedException ex) {
            }
        }

        res = body[nextOut];
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        available--;

        if (res==null)
            System.out.println("Time " + c.time + ": " + name + " invalid item");

        nextOut++;
        if (nextOut==body.length)
            nextOut=0;

        if (available == 0)
            System.out.println("Time " + c.time + ": " + name + " buffer empty");

        notifyAll();
        return res;
    }
}
