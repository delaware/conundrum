import model.*;

public class Main {

    public static void main(String[] args) {

        Clock clock = new Clock();
        clock.start();

        Belt inputA = new Belt(2, clock, "InputBelt A");
        Belt inputB = new Belt(3, clock, "InputBelt B");
        Belt[] belts = {inputA,inputB};


        Belt beltA = new Belt(2, clock, "Belt A");
        Belt beltB = new Belt(2, clock, "Belt B");
        Belt beltC = new Belt(2, clock, "Belt C");

        Sack c1 = new Sack(inputA,1,clock,1);
        Sack c2 = new Sack(inputB,2,clock,2);
//        Sack c1 = new Sack(beltA,1,clock,1);
//        Sack c2 = new Sack(beltA,2,clock,2);
//        Sack c3 = new Sack(beltB,3,clock,3);
//        Sack c4 = new Sack(beltC,4,clock,4);

        Turntable turnA = new Turntable(inputA,beltA,null,null,clock);
//        Turntable turnB = new Turntable(inputB,beltA,c1,beltB);
//        Turntable turnC = new Turntable(beltB,c2,c3,c4);

        turnA.start();

        // initialize RedHattedElves
        int numReds = 5;
        RedHatElf redElves[] = new RedHatElf[numReds];

        for(int i=0;i<redElves.length;i++) {
            redElves[i] = new RedHatElf(i,belts,clock);
            redElves[i].start();
        }

        c1.start();
        c2.start();
//        c3.start();
//        c4.start();

        try {
            for(int i=0;i<redElves.length;i++) {
                redElves[i].join();
            }
        } catch (InterruptedException ex) {}

        Gift g = new Gift("END",0);
        inputA.insert(g);
        inputB.insert(g);
        beltA.insert(g);
        beltB.insert(g);
        beltC.insert(g);

        try {
            c1.join();
            c2.join();
//            c3.join();
//            c4.join();
        } catch (InterruptedException ex) {}

        turnA.requestStop();
        clock.requestStop();

        System.out.println("Theme Park closed:");
        for(int i=0;i<redElves.length;i++) {
            redElves[i].status();
        }
    }
}