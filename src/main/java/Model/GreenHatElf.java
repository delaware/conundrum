package model;

// delivers gifts to grottos
public class GreenHatElf extends Elf {
    Sack[] sacks;
    private boolean stop = false;

    public GreenHatElf(int id, Sack[] sacks, Clock clock) {
        super(id,clock);
        this.sacks = sacks;
    }

    public void produce(){
        int i = (int) (Math.random() * sacks.length);
        if(sacks[i].empty()) {
            number++;
            System.out.println(c.time + ": " + name + " has empty " + sacks[i].name);
        } else {
            incTicksWaited();
        }
    }

    public void run() {
        while(!stop){
            try {
                sleep(motivation);
            } catch (InterruptedException ex) {}
            produce();
        }
    }

    public void status() {
        System.out.println(name + " took " + number + " sacks, waited " + ticks + " ticks! (Motivation:" + motivation + ")");
    }

    public void requestStop() {
        stop = true;
    }
}
