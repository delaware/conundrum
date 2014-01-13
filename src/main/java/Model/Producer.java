package model;

public class Producer extends Thread {
    Belt buf;
    Clock c;
    int id;
    int number;

    public Producer(int id, Belt b, int numItems, Clock c){
        this.id = id;
        this.c = c;
        buf = b;
        number = numItems;
    }
    public void produce(int i){
        System.out.println("Time " + c.time() + ": Producer "+id+" producing item: "+ i);
        buf.insert("item: "+i+"(Producer "+id+")");
    }

    public void run() {
        for (int i=0; i < number; i++){
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
            produce(i);
        }

    }
}
