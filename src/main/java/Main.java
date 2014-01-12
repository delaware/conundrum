import model.*;

public class Main {

    public static void main(String[] args) {

        Belt b = new Belt(2);
        Sack c1 = new Sack(b,1);
        Sack c2 = new Sack(b,2);
        Producer p1 = new Producer(1,b,5);
        Producer p2 = new Producer(2,b,5);
        c1.start();
        c2.start();
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (InterruptedException ex) {
        }
        b.insert("*****");
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException ex) {

        }
    }
}