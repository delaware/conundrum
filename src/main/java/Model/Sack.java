package model;

public class Sack extends Thread {
    Belt buf;
    int id;
    Clock c;

    public Sack(Belt b, int consumerNum, Clock c) {
        buf = b;
        this.c = c;
        id = consumerNum;
    }
    public boolean consume(){
        String nextItem = buf.extract();
        System.out.println("Time " + c.time() + ": Consumer "+id+" consuming: "+ nextItem);
        return !nextItem.equals("****");
    }

    public void run(){
        while(consume()){
            try {
                sleep( (int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
        }
        buf.insert("****");
    }
}
