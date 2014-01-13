package model;

public class Sack extends Thread {
    Belt buf;
    int id;
    Clock c;
    int group;

    public Sack(Belt b, int consumerNum, Clock c, int group) {
        this.buf = b;
        this.c = c;
        this.id = consumerNum;
        this.group = group;
    }
    public boolean consume(){
        Gift nextItem = buf.extract();
        //if(nextItem.getGroup() == group) {
            System.out.println("Time " + c.time() + ": Consumer "+ group +" consuming: "+ nextItem.getName() + " cat: " + nextItem.getGroup());
        //}
        return nextItem!=null;
    }

    public void run(){
        while(consume()){
            try {
                sleep( (int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
        }
        buf.insert(null);
    }
}
