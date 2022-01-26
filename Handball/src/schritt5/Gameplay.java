package schritt5;

import schritt1.Spieler;
import schritt2.Torwart;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {

    private static final int spielzeit = 90;
    private static final int nachSpielZeit = 5;
    private static final int naechsteAktion = 10;

    private static int ermittelMannschaftsWert(Mannschaft mannschaft){
       int mannschaftsWert =  mannschaft.getMotivation() * mannschaft.getStaerke();
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
        if (torschuss > reaktion){
            tor = true;
        }else{
            tor = false;
        }
        return tor;
    }

    public static void spielen(Spiel spiel){
        Random r = new Random();
        int zahl = r.nextInt(nachSpielZeit);
        int spieldauaer = spielzeit + zahl;


        Mannschaft heim = spiel.getHeim();
       int mannschaftsWertHeim = ermittelMannschaftsWert(heim);
       Mannschaft gast = spiel.getGast();
       int mannschaftsWertGast = ermittelMannschaftsWert(gast);

       int summe = mannschaftsWertGast + mannschaftsWertHeim;
       int zufall = r.nextInt(summe);
       
       if (zufall > mannschaftsWertHeim){
          ArrayList<Spieler> gast_ = gast.getSpielerListe();
          zufall = r.nextInt(gast_.size());
          Spieler schuetze = gast_.get(zufall);
          Torwart torwart = heim.getTorwart();
          erzieltTor(schuetze,torwart);

       }else{
           ArrayList<Spieler> heim_ = heim.getSpielerListe();
           zufall = r.nextInt(heim_.size());
           Spieler schuetze = heim_.get(zufall);
           Torwart torwart = gast.getTorwart();
           erzieltTor(schuetze,torwart);
       }
    }

}
