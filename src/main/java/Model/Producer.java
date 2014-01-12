package model;

public class Producer extends Thread {
    Belt buf;
    int id;
    int number;
    public Producer(int id, Belt b, int numItems){
        this.id = id;
        buf = b;
        number = numItems;
    }
    public void produce(int i){
        System.out.println("Producer "+id+" producing item: "+i);
        buf.insert("item: "+i+"(Producer "+id+")");
    }

    public void run() {
        for (int i=0; i < number; i++){
            try {
                sleep((int) (Math.random() * 5));
            } catch (InterruptedException ex) {
            }
            produce(i);
        }

    }
}
