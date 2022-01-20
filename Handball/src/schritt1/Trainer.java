package schritt1;

import schritt3.Person;

public class Trainer extends Person {


    private int erfahrung;

    public Trainer(String name, int alter, int erfahrung) {
        super(alter, name);
        this.erfahrung = erfahrung;
    }

    @Override
    public String toString() {
        return "\nTrainer: " + getName()
                + "\nAlter: " + getAlter()
                + "\nErfahrung: " + getErfahrung();
    }

    //getter



    public int getErfahrung() {
        return erfahrung;
    }



    //setter



    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }



}
