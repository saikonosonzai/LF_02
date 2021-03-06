package schritt4;

public class Spiel {
    private Ergebnis ergebnis;
    private Mannschaft gast;
    private Mannschaft heim;
    private StringBuilder spielverlauf;

    public Spiel(Ergebnis ergebnis, Mannschaft gast, Mannschaft heim){
        this.ergebnis = ergebnis;
        this.gast = gast;
        this.heim = heim;
        spielverlauf = new StringBuilder();
    }

    public Ergebnis getErgebnis() {
        return ergebnis;
    }

    public Mannschaft getGast() {
        return gast;
}

    public Mannschaft getHeim() {
        return heim;
    }

    public StringBuilder getSpielbericht() {
        return spielverlauf;
    }

    @Override
    public String toString() {
        return  "\nergebnis: " + getErgebnis() +
                "\nspielverlauf: " + getSpielbericht();
    }
}
