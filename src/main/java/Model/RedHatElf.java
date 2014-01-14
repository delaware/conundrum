package model;

// producing gifts for sorting machine
public class RedHatElf extends Elf {
    Belt[] belts;

    public RedHatElf(int id, Belt[] belts, Clock clock) {
        super(id,clock);
        this.belts = belts;
    }

    public void produce(){
        Gift g = new Gift(this);
        System.out.println("Time " + c.time() + ": " + this.name + " producing item: " + g.getName() + " cat:" + g.getGroup());
        int i = (int) Math.random()*(belts.length+1);
        belts[i].insert(g);
    }

    public void run() {
        while(c.time < c.endOfDay){
            try {
                sleep(motivation);
            } catch (InterruptedException ex) {
            }
            produce();
            number++;
        }
    }

    public void status() {
        System.out.println(name + " deposited " + number + " gifts, waited " + ticks + " ticks! (Motivation:" + motivation + ")");
    }
}
