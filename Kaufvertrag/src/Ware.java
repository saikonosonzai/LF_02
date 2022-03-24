import com.itextpdf.layout.element.Cell;

import java.util.ArrayList;

public class Ware {
    private String bezeichnung;
    private String beschreibung;
    private double preis;
    private ArrayList<String> besonderheiten;
    private ArrayList<String> maengel;

    public Ware(String bezeichnung,double preis){
        besonderheiten = new ArrayList<String>();
        maengel = new ArrayList<String>();
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public ArrayList<String> getBesonderheiten() {
        return besonderheiten;
    }

    public ArrayList<String> getMaengel() {
        return maengel;
    }

    public void setBesonderheiten(ArrayList<String> besonderheiten) {
        this.besonderheiten = besonderheiten;
    }

    public void setMaengel(ArrayList<String> maengel) {
        this.maengel = maengel;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "\nBezeichnung: "+getBezeichnung()+
                "\nBeschreibung: "+getBeschreibung()+
                "\nBesonderheten: "+getBesonderheiten()+
                "\nMängel: "+getMaengel();
    }
}
