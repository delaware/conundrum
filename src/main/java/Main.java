import model.*;

public class Main {

    public static void main(String[] args) {

        Clock clock = new Clock();
        clock.start();

        Belt beltA = new Belt(3, clock);
        Belt beltB = new Belt(4, clock);

        Sack c1 = new Sack(beltA,1,clock,1);
        Sack c2 = new Sack(beltA,2,clock,2);
        Sack c3 = new Sack(beltB,3,clock,3);
        Sack c4 = new Sack(beltB,4,clock,4);

        RedHatElf p1 = new RedHatElf(1,beltA,clock);
        RedHatElf p2 = new RedHatElf(2,beltA,clock);
        RedHatElf p3 = new RedHatElf(3,beltB,clock);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        p1.start();
        p2.start();
        p3.start();

        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException ex) {}

        Gift g = new Gift("END",0);
        beltA.insert(g);
        beltB.insert(g);

        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException ex) {}

        clock.requestStop();
    }
}