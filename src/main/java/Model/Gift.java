package model;

public class Gift {

    private int group;
    private String wrapper;
    private String name;

    public Gift(String wrapper) {
        this.wrapper = wrapper;
        randomizeCategory();
        randomizeName();
    }

    public void randomizeName() {
        String[] names = {"train","doll","dinosaur","whistle","fake tattoo","bracelet"};
        int i = (int) (Math.random() * names.length);
        this.name = names[i];
    }

    // 1 .. 00-04 years
    // 2 .. 04-08 years
    // 3 .. 08-12 years
    // 4 .. 12-16 years
    public void randomizeCategory() {
        this.group = (int) (2*Math.random()+1);
    }

    public int getGroup() {
        return this.group;
    }

    public String getWrapper() {
        return this.wrapper;
    }

    public String getName() {
        return this.name;
    }
}
