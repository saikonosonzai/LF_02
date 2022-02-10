public class Kunde extends Person {
    private Mitarbeiter mitarbeiter;
    public Kunde(String name, Adresse adresse, Mitarbeiter mitarbeiter){
        super(name, adresse);
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public String toString() {
        return super.toString() + "Kunde{" +
                "mitarbeiter=" + mitarbeiter +
                '}';
    }
}
