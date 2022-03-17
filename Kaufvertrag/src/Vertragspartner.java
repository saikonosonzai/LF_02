public class Vertragspartner {
    private String vorname;
    private String nachname;
    private String ausweisNr;
    private Adresse adresse;

    public Vertragspartner(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAusweisNr() {
        return ausweisNr;
    }

    public void setAusweisNr(String ausweisNr) {
        this.ausweisNr = ausweisNr;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "\nVorname: "+getVorname()+
                "\nNachname: "+getNachname()+
                "\nAusweißnummer: "+getAusweisNr()+
                "\nAdresse:\n"+getAdresse();
    }
}
