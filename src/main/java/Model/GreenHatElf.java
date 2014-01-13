package model;

// delivers gifts to grottos
public class GreenHatElf extends Elf {

    public GreenHatElf(int id, Belt b, int numItems, Clock c) {
        super(id,b,numItems,c);
    }

    public void produce(int i){
        Gift g = new Gift(this.name);
        System.out.println("Time " + c.time() + ": " + this.name + " producing item: " + g.getName() + " cat:" + g.getGroup());
        buf.insert(g);
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
