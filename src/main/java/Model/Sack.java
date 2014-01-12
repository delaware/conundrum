package model;

public class Sack extends Thread {
    Belt buf;
    int id;
    public Sack(Belt b, int consumerNum) {
        buf = b;
        id = consumerNum;
    }
    public boolean consume(){
        String nextItem = buf.extract();
        System.out.println("Consumer "+id+" consuming: "+nextItem);
        return !nextItem.equals("****");
    }

    public void run(){
        while(consume()){
            try {
                sleep( (int) (Math.random() * 5));
            } catch (InterruptedException ex) {
            }
        }
        buf.insert("****");
    }
}
