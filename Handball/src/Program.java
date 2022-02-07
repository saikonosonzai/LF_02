import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;
import schritt5.Gameplay;
import schritt6.SpielAbbruchException;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SpielAbbruchException {
        ArrayList<Spieler> spielerGast = new ArrayList<>();
        ArrayList<Spieler> spielerHeim = new ArrayList<>();

        Trainer trainer = new Trainer("Hans", 30, 7);

        Spieler spieler = new Spieler("Hanes", 25, 3, 4, 6, 2);
        spielerHeim.add(spieler);

        spieler = new Spieler("Hannes", 25, 3, 2, 9, 5);
        spielerHeim.add(spieler);

        spieler = new Spieler("Hanne", 25, 3, 5, 1, 10);
        spielerHeim.add(spieler);

        Torwart torwart = new Torwart("Klaus",30,6,7,9);

        Mannschaft heim = new Mannschaft("Heim",trainer,torwart,spielerHeim);

        System.out.println(heim);



        Trainer trainer1 = new Trainer("Paul", 56, 10);

        Spieler spieler1 = new Spieler("annes", 25, 3, 7, 6, 2);
        spielerHeim.add(spieler1);

        spieler1 = new Spieler("Hans", 25, 3, 2, 4, 5);
        spielerHeim.add(spieler1);

        spieler1 = new Spieler("Has", 25, 3, 1, 7, 5);
        spielerHeim.add(spieler1);

        Torwart torwart1 = new Torwart("z8fu",80,6,4,6);
        spielerGast.add(spieler1);

        Mannschaft gast = new Mannschaft("Gast",trainer1,torwart1,spielerGast);

        System.out.println(gast);
        Ergebnis ergebnis = new Ergebnis();
        Spiel spiel = new Spiel(ergebnis,gast,heim);
            Gameplay.spielen(spiel);
        try {
            Gameplay.spielen(spiel);
        } catch (SpielAbbruchException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(spiel);
    }
}
