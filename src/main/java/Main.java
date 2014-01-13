import model.*;

public class Main {

    public static void main(String[] args) {

        Clock clock = new Clock();
        Thread tc = new Thread(clock);
        tc.start();

        Belt beltA = new Belt(6, clock);
        Belt beltB = new Belt(2, clock);

        Sack c1 = new Sack(beltA,1,clock);
        Sack c2 = new Sack(beltA,2,clock);
        Sack c3 = new Sack(beltB,3,clock);
        Sack c4 = new Sack(beltB,4,clock);

        Producer p1 = new Producer(1,beltA,50,clock);
        Producer p2 = new Producer(2,beltA,50,clock);
        Producer p3 = new Producer(3,beltB,50,clock);

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
        } catch (InterruptedException ex) {
        }
        beltA.insert("*****");
        beltB.insert("*****");
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException ex) {}

        tc.interrupt();

    }
}