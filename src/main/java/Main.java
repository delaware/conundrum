import model.*;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            Elve e = new Elve();
            e.start();
            try{
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // nichts
            }
            e.stop();
        }

        for(int i = 0; i < 2; i++) {
            Belt b = new Belt();
            b.start();
            try{
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // nichts
            }
            b.stop();
        }
    }
}