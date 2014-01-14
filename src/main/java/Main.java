import model.*;

import java.awt.*;

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

        Sack c1 = new Sack(1,clock,"Sack C1",1);
        Sack c2 = new Sack(2,clock,"Sack C2",2);
        Sack c3 = new Sack(3,clock,"Sack C3",3);
        Sack c4 = new Sack(4,clock,"Sack C4",4);

        Sack[] sacks = {c1,c2,c3,c4};

        Turntable turnA = new Turntable(inputA,beltA,null,null,clock,"Turn A");
        Turntable turnB = new Turntable(inputB,c1,beltB,beltA,clock,"Turn B");
        Turntable turnC = new Turntable(beltB,c2,c3,c4,clock,"Turn C");

        Thread thTurnA = new Thread(turnA);
        thTurnA.start();

        Thread thTurnB = new Thread(turnB);
        thTurnB.start();

        Thread thTurnC = new Thread(turnC);
        thTurnC.start();

        // initialize RedHattedElves
        int numReds = 5;
        RedHatElf redElves[] = new RedHatElf[numReds];

        for(int i=0;i<redElves.length;i++) {
            redElves[i] = new RedHatElf(i,belts,clock);
            redElves[i].start();
        }

        // initialize RedHattedElves
        int numGreens = 5;
        GreenHatElf greenElves[] = new GreenHatElf[numGreens];

        for(int i=0;i<greenElves.length;i++) {
            greenElves[i] = new GreenHatElf(i,sacks,clock);
            greenElves[i].start();
        }

        try {
            for(int i=0;i<redElves.length;i++) {
                redElves[i].join();
            }
            for(int i=0;i<greenElves.length;i++) {
                greenElves[i].join();
            }
        } catch (InterruptedException ex) {}




        Gift g = new Gift("END",0);
        inputA.insert(g);
        inputB.insert(g);
        beltA.insert(g);
        beltB.insert(g);
        beltC.insert(g);

        turnA.requestStop();
        turnB.requestStop();
        turnC.requestStop();
        clock.requestStop();

        System.out.println("Theme Park closed:");
        for(int i=0;i<redElves.length;i++) {
            redElves[i].status();
        }
        for(int i=0;i<greenElves.length;i++) {
            greenElves[i].status();
        }
    }
}