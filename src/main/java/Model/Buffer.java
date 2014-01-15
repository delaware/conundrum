package model;

public class Buffer {

    protected Gift [] body;
    protected int nextIn=0;
    protected int nextOut=0;
    protected int available;
    protected Clock c;
    protected String name;
    protected int category;
    protected boolean isSack = false;

    public Buffer(int size, Clock c, String name){
        body = new Gift[size];
        this.c = c;
        this.name = name;
        this.available = 0;
    }

    public synchronized void insert(Gift item){
        while (available == body.length){
            System.out.println("Time " + c.time + ": " + name + " insert waiting");
            try {
                wait();
                if(item.getWrapper() != null ) { item.getWrapper().incTicksWaited(); }
            }
            catch (InterruptedException ex) {}

        }
        body[nextIn] = item;
        available = available + 1;
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {}
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
            catch (InterruptedException ex) {}
        }

        res = body[nextOut];
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {}
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

    public boolean isSack() {
        return isSack;
    }
}
