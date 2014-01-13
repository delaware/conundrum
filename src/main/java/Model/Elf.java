package model;

public class Elf extends Thread {
    // random name
    protected String name;
    protected int motivation = (int) (Math.random()*500)+500;

    Belt[] belts;
    Clock c;
    int id;
    int number;
    int ticks;

    public Elf(int id, Belt[] b, Clock c) {
        this.id = id;
        this.c = c;
        belts = b;
        createName();
    }

    public void createName() {
        String[] firstnames = {"Bob","Jill","Tom","Brandon","Alice","Jenny"};
        String[] lastnames = {"Hofer","Maier","Eder","Krampus","Wonderland","McGood"};

        int i = (int) (Math.random() * lastnames.length);
        int j = (int) (Math.random() * firstnames.length);
        this.name = firstnames[j] + " " + lastnames[i];
    }

    public void incTicksWaited() {
        ticks++;
    }
}
