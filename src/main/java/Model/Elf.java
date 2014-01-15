package model;

public class Elf extends Thread {
    // random name
    protected String name;
    protected int motivation = (int) (Math.random()*500)+500;

    Clock c;
    int id;
    int number;
    int ticks;

    public Elf(int id, Clock c) {
        this.id = id;
        this.c = c;
        createName();
    }

    public void createName() {
        String[] firstnames = {"Bob","Jill","Tom","Brandon","Alice","Jenny","Rudolph","Bilbo","Frodo"};
        String[] lastnames = {"Hofer","Maier","Eder","Krampus","Wonderland","McGood","Baggin"};

        int i = (int) (Math.random() * lastnames.length);
        int j = (int) (Math.random() * firstnames.length);
        this.name = firstnames[j] + " " + lastnames[i];
    }

    public void incTicksWaited() {
        ticks++;
    }
}
