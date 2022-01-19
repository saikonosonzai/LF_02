package schritt1;

public class Trainer {

    private String name;
    private int alter;
    private int erfahrung;

    public Trainer(String name, int alter, int erfahrung) {
        this.name = name;
        this.alter = alter;
        this.erfahrung = erfahrung;
    }

    @Override
    public String toString() {
        return "\nname: " + getName()
                + "\nalter: " + getAlter()
                + "\nerfahrung: " + getErfahrung();
    }

    //getter

    public int getAlter() {
        return alter;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public String getName() {
        return name;
    }

    //setter

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public void setName(String name) {
        this.name = name;
    }

}
