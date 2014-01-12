package model;

public class Gift {

    private int category;

    public Gift() {
        this.category = (int) (5*Math.random());
        System.out.println(this.category);
    }
}
