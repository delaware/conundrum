package model;

public class Sack extends Thread {
    Belt belt;
    int id;
    Clock c;
    int group;
    private Gift [] body;

    public Sack(Belt b, int consumerNum, Clock c, int group) {
        this.belt = b;
        this.c = c;
        this.id = consumerNum;
        this.group = group;
        body = new Gift[20];
    }
    public boolean consume(){
        Gift nextItem = belt.extract();
        System.out.println("Time " + c.time() + ": Consumer "+ group +" consuming: "+ nextItem.getName() + " cat: " + nextItem.getGroup());
        return !nextItem.getName().equals("END");
    }

    public void run(){
        while(consume()){
            try {
                sleep( (int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
        }
        Gift g = new Gift("END",0);
        belt.insert(g);
    }
}
