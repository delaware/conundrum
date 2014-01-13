package model;

public class Elf extends Thread {
    // random name
    protected String name;

    Belt buf;
    Clock c;
    int id;
    int number;

    public Elf(int id, Belt b, int numItems, Clock c) {
        this.id = id;
        this.c = c;
        buf = b;
        number = numItems;
        createName();
    }

    public void createName() {
        String[] firstnames = {"Bob","Jill","Tom","Brandon","Alice","Jenny"};
        String[] lastnames = {"Hofer","Maier","Eder","Krampus","Wonderland","McGood"};

        int i = (int) (Math.random() * lastnames.length);
        int j = (int) (Math.random() * firstnames.length);
        this.name = firstnames[j] + " " + lastnames[i];
    }
}
