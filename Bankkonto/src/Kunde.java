public class Kunde extends Person {
    private Mitarbeiter mitarbeiter;
    public Kunde(String name, Mitarbeiter mitarbeiter){
        super(name);
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public String toString() {
        return super.toString() + "Kunde{" +
                "mitarbeiter=" + mitarbeiter +
                '}';
    }
}
