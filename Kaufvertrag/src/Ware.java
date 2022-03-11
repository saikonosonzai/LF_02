import java.util.ArrayList;

public class Ware {
    private String bezeichnung;
    private String beschreibung;
    private double preis;
    private ArrayList<String> maengel;
    private ArrayList<String> besonderheiten;

    public Ware(String beschreibung, String bezeichnung, double preis, ArrayList<String> maengel, ArrayList<String> besonderheiten){
        this.beschreibung = beschreibung;
        this.besonderheiten = besonderheiten;
        this.maengel = maengel;
        this.preis = preis;
        this.bezeichnung = bezeichnung;
    }

    public ArrayList<String> getBesonderheiten() {
        return besonderheiten;
    }

    public ArrayList<String> getMaengel() {
        return maengel;
    }

    public double getPreis() {
        return preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setBesonderheiten(ArrayList<String> besonderheiten) {
        this.besonderheiten = besonderheiten;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setMaengel(ArrayList<String> maengel) {
        this.maengel = maengel;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "bezeichnung='" + bezeichnung + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", preis=" + preis +
                ", maengel=" + maengel +
                ", besonderheiten=" + besonderheiten +
                '}';
    }
}
