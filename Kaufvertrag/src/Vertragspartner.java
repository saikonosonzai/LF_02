public class Vertragspartner {
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private String ausweisNr;

    public Vertragspartner(String vorname, String nachname, Adresse adresse, String ausweisNr){
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.ausweisNr = ausweisNr;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getAusweisNr() {
        return ausweisNr;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setAusweisNr(String ausweisNr) {
        this.ausweisNr = ausweisNr;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "Vertragspartner{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", adresse=" + adresse +
                ", ausweisNr='" + ausweisNr + '\'' +
                '}';
    }
}
