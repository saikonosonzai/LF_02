package schritt5;
import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {

    private static final int SPIELZEIT = 90;
    private static final int NACH_SPIEL_ZEIT = 5;
    private static final int NAECHSTE_AKTION = 10;

    private static int ermittelMannschaftsWert(Mannschaft mannschaft){
        Trainer trainer = mannschaft.getTrainer();
       int mannschaftsWert =  mannschaft.getMotivation() * mannschaft.getStaerke() * trainer.getErfahrung();
       if (mannschaftsWert == 0){
           mannschaftsWert = 1;
       }
        return mannschaftsWert;
    }

    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {

        boolean tor;
        Random r = new Random();
        int wert = r.nextInt(5) - 2;
        int wert1 = r.nextInt(5) - 2;

        int torschuss = schuetze.getTorschuss() + wert;
        if(torschuss <= 0){
            torschuss = 1;
        }
        int reaktion = torwart.getReaktion() + wert1;
        if (reaktion <= 0){
            reaktion = 1;
        }
        tor = torschuss > reaktion;
        return tor;
    }

    public static void spielen(Spiel spiel){
        Random r = new Random();
        int zahl = r.nextInt(NACH_SPIEL_ZEIT + 1);
        int spielZeit = SPIELZEIT + zahl;
        int naechsteAktionZufall = r.nextInt(NAECHSTE_AKTION + 1);
        spielZeit -= naechsteAktionZufall;

do {
    Mannschaft heim = spiel.getHeim();
    int mannschaftsWertHeim = ermittelMannschaftsWert(heim);
    Mannschaft gast = spiel.getGast();
    int mannschaftsWertGast = ermittelMannschaftsWert(gast);
    int summe = mannschaftsWertGast + mannschaftsWertHeim;

    Mannschaft offensiv;
    Mannschaft defensiv;
    int zufall = r.nextInt(summe + 1);
    if (zufall > mannschaftsWertHeim){
        offensiv = heim;
        defensiv = gast;
        System.out.println("Torschuss heim bei min: "+spielZeit);
    }else{
        offensiv = gast;
        defensiv = heim;
        System.out.println("Torschuss gast bei min: "+spielZeit);
    }
    Ergebnis ergebnis = spiel.getErgebnis();
    ArrayList<Spieler> spielerArrayList = offensiv.getSpielerListe();
    Spieler schuetze = spielerArrayList.get(r.nextInt(spielerArrayList.size()));
    Torwart torwart = defensiv.getTorwart();
    boolean tor = erzieltTor(schuetze, torwart);
    if (offensiv == gast && tor){
        System.out.println("Treffer Gast bei min: "+spielZeit);
        ergebnis.TrefferGast();
        schuetze.setTore(+1);
    }else{
        if (offensiv == heim && tor){
            System.out.println("Treffer heim bei min: "+spielZeit);
            ergebnis.TrefferHeim();
            schuetze.setTore(+1);
        }

    }
spielZeit -= naechsteAktionZufall = r.nextInt(NAECHSTE_AKTION + 1);
}while(spielZeit > 0);
    }
}