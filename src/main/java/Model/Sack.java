package model;

public class Sack extends Buffer {
    int id;
    int category;
    static int size = 20;

    public Sack(int consumerNum, Clock c, String name, int category) {
        super(size,c,name,false);
        this.id = consumerNum;
        this.category = category;
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
        for (int i = 0; i < body.length; i ++)
            if (body[i] != null)
                counter ++;

        if(counter >= size/2) {
            System.out.println(counter);
            body = new Gift[size];
            return true;
        }
        return false;
    }
}
