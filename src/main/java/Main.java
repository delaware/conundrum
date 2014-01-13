import model.*;

public class Main {

    public static void main(String[] args) {

        Clock clock = new Clock();
        clock.start();

        Belt beltA = new Belt(2, clock, "Belt A");
        Belt beltB = new Belt(3, clock, "Belt B");
        Belt beltC = new Belt(2, clock, "Belt C");
        Belt[] belts = {beltA,beltB,beltC};

        // initialize RedHattedElves
        int numReds = 5;
        RedHatElf redElves[] = new RedHatElf[numReds];

        for(int i=0;i<redElves.length;i++) {
            redElves[i] = new RedHatElf(i,belts,clock);
            redElves[i].start();
        }


        Sack c1 = new Sack(beltA,1,clock,1);
        Sack c2 = new Sack(beltA,2,clock,2);
        Sack c3 = new Sack(beltB,3,clock,3);
        Sack c4 = new Sack(beltC,4,clock,4);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        try {
            for(int i=0;i<redElves.length;i++) {
                redElves[i].join();
            }
        } catch (InterruptedException ex) {}

        Gift g = new Gift("END",0);
        beltA.insert(g);
        beltB.insert(g);
        beltC.insert(g);

        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException ex) {}

        clock.requestStop();

        System.out.println("Theme Park closed:");
        for(int i=0;i<redElves.length;i++) {
            redElves[i].status();
        }
    }
}