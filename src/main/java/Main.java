import model.*;

public class Main {

    public static void main(String[] args) {

        int numRedHatElf = 5;
        int numGreenHatElf = 1;

        Clock clock = new Clock();
        clock.start();

        Belt inputA = new Belt(8, clock, "InputBelt A");
        Belt inputB = new Belt(4, clock, "InputBelt B");

        Belt beltA = new Belt(6, clock, "Belt A");
        Belt beltB = new Belt(2, clock, "Belt B");

        Sack c1 = new Sack(1,clock,"Sack C1");
        Sack c2 = new Sack(2,clock,"Sack C2");
        Sack c3 = new Sack(3,clock,"Sack C3");
        Sack c4 = new Sack(4,clock,"Sack C4");

        // additional information for the elves
        Belt[] belts = {inputA,inputB};
        Sack[] sacks = {c1,c2,c3,c4};

        Turntable turnA = new Turntable(inputA,beltA,null,null,8,clock,"Turn A");
        Turntable turnB = new Turntable(inputB,c1,beltB,beltA,9,clock,"Turn B");
        Turntable turnC = new Turntable(beltB,c2,c3,c4,8,clock,"Turn C");

        Thread thTurnA = new Thread(turnA);thTurnA.start();
        Thread thTurnB = new Thread(turnB);thTurnB.start();
        Thread thTurnC = new Thread(turnC);thTurnC.start();

        // initialize RedHattedElves
        RedHatElf redElves[] = new RedHatElf[numRedHatElf];
        for(int i=0;i<redElves.length;i++) {
            redElves[i] = new RedHatElf(i,belts,clock);
            redElves[i].start();
        }

        // initialize RedHattedElves
        GreenHatElf greenElves[] = new GreenHatElf[numGreenHatElf];
        for(int i=0;i<greenElves.length;i++) {
            greenElves[i] = new GreenHatElf(i,sacks,clock);
            greenElves[i].start();
        }

        try {
            for(int i=0;i<redElves.length;i++) {
                redElves[i].join();
            }
        } catch (InterruptedException ex) {}

        // if this gift equals a stop signal
//        Gift g = new Gift("END",0);
//        inputA.insert(g);
//        inputB.insert(g);
//        beltA.insert(g);
//        beltB.insert(g);

        turnA.requestStop();
        turnB.requestStop();
        turnC.requestStop();
        clock.requestStop();

        System.out.println("Theme Park closed:");
        for(int i=0;i<redElves.length;i++) {
            redElves[i].status();
        }
        for(int i=0;i<greenElves.length;i++) {
            greenElves[i].requestStop();
            greenElves[i].status();
        }
    }
}