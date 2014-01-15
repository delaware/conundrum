package model;

public class Sack extends Buffer {
    static int size = 10;


    public Sack(int consumerNum, Clock c, String name, int category) {
        super(size,c,name);
        this.category = category;
        this.isSack = true;
    }

//    public boolean consume(){
//        Gift nextItem = belt.extract();
//        System.out.println("Time " + c.time() + ": Consumer "+ group +" consuming: "+ nextItem.getName() + " cat: " + nextItem.getGroup());
//        return !nextItem.getName().equals("END");
//    }


//    public void run(){
//        while(consume()){
//            try {
//                sleep( (int) (Math.random() * 1000));
//            } catch (InterruptedException ex) {
//            }
//        }
//        Gift g = new Gift("END",0);
//        belt.insert(g);
//    }

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
//            System.out.println(name + " has " + counter + " gifts");
            available = 0;
            nextIn = 0;
            nextOut = 0;
            return true;
        }
        return false;
    }


}
