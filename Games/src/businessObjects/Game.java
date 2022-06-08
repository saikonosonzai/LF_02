package businessObjects;

import java.util.ArrayList;

public class Game {
    private int nr;
    private String bezeichnung;
    private ArrayList<String> genre;
    private double preis;
    private String entwickler;
    private double bewertung;

    public int getNr() {
        return nr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Game(String bezeichnung){
        this.bezeichnung = bezeichnung;
        genre =  new ArrayList<>();
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getEntwickler() {
        return entwickler;
    }

    public void setEntwickler(String entwickler) {
        this.entwickler = entwickler;
    }

    public double getBewertung() {
        return bewertung;
    }

    public void setBewertung(double bewertung) {
        this.bewertung = bewertung;
    }

    @Override
    public String toString() {
        return "Game{" +
                "nr=" + nr +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", genre=" + genre +
                ", preis=" + preis +
                ", entwickler='" + entwickler + '\'' +
                ", bewertung=" + bewertung +
                '}';
    }
}
