package model;

public class Elve extends Thread {
    private String firstname;
    private String lastname;

    public void run() {
        createName();
        System.out.println(printName());
    }

    public void createName() {
        String[] firstnames = {"Bob", "Jill", "Tom", "Brandon"};
        String[] lastnames = {"Hofer", "Maier", "Reiter", "Krampus"};

        int i = (int) (Math.random() * lastnames.length);
        this.lastname = lastnames[i];
        int j = (int) (Math.random() * firstnames.length);
        this.firstname = firstnames[j];
    }

    public String printName() {
        return "Your random name is " + this.firstname + " " + this.lastname + " now!";
    }
}
