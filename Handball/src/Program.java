import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {



        Trainer trainer = new Trainer("Hans", 30, 7);
        Spieler spieler = new Spieler("Hannes", 25, 3, 8, 6, 2);
        Torwart torwart = new Torwart("Klaus",30,6,7,9);
        ArrayList<Spieler> spielerHeim = new ArrayList<>();
        spielerHeim.add(spieler);
        Mannschaft heim = new Mannschaft("Heim",trainer,torwart,spielerHeim);


        Trainer trainer1 = new Trainer("Paul", 1000, 10);
        Spieler spieler1 = new Spieler("tvglu", 3, 5, 1, 1, 1);
        Torwart torwart1 = new Torwart("z8fu",80,6,7,9);
        ArrayList<Spieler> spielerGast = new ArrayList<>();
        spielerGast.add(spieler1);
        Mannschaft gast = new Mannschaft("Gast",trainer1,torwart1,spielerGast);


        Ergebnis ergebnis = new Ergebnis();
        ergebnis.TrefferGast();
        Spiel spiel = new Spiel(ergebnis,gast,heim);
        System.out.println(gast);
        System.out.println(heim);

        System.out.println(spiel);
    }
}
