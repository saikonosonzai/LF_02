package schritt4;

import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;

import java.util.ArrayList;

public class Mannschaft {
    private String name;
    private Trainer trainer;
    private Torwart torwart;
    private ArrayList <Spieler> spielerListe;
    private int motivation = 0;
    private int staerke = 0;



    public Mannschaft(String name, Trainer trainer, Torwart torwart, ArrayList spielerListe){
        this.name = name;
        this.trainer = trainer;
        this.torwart = torwart;
        this.spielerListe = spielerListe;
    }
    public int getMotivation(){

        for (Spieler s: spielerListe) {
          motivation += s.getMotivation();
        }
        motivation += torwart.getMotivation();
        int motivationDurchschnitt = motivation/(spielerListe.size() + 1);
        return motivationDurchschnitt;
    }
    public int getStaerke(){

        for (Spieler s: spielerListe) {
            staerke += s.getStaerke();
        }
        staerke += torwart.getStaerke();
        int staerkeDurschnitt = staerke/(spielerListe.size() + 1);
        return staerkeDurschnitt;
    }

    public String getName() {
        return name;
    }

    public Torwart getTorwart() {
        return torwart;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public ArrayList<Spieler> getSpielerListe() {
        return spielerListe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTorwart(Torwart torwart) {
        this.torwart = torwart;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setSpielerListe(ArrayList<Spieler> spielerListe) {
        this.spielerListe = spielerListe;
    }
}
