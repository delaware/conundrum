package model;

// delivers gifts to grottos
public class GreenHatElf extends Elf {

    public GreenHatElf(int id, Belt[] b, Clock c) {
        super(id,b,c);
    }

    public void produce(int i){
        Gift g = new Gift(this);
        System.out.println("Time " + c.time() + ": " + this.name + " producing item: " + g.getName() + " cat:" + g.getGroup());
        int j = (int) Math.random() * belts.length;
        belts[j].insert(g);
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
