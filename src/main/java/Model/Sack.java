package model;

public class Sack extends Buffer {
    static int size = 20;


    public Sack(int category, Clock c, String name) {
        super(size,c,name);
        this.category = category;
        this.isSack = true;
    }

    public boolean empty() {
        int counter = 0;
        for (int i = 0; i < body.length; i ++) {
            if (body[i] != null)
                counter ++;
        }

        if(counter >= size/2) {
            for (int i = 0; i < body.length; i ++) {
                body[i] = null;
            }
            // System.out.println(name + " has " + counter + " gifts");
            available = 0;
            nextIn = 0;
            nextOut = 0;
            return true;
        }
        return false;
    }
}
