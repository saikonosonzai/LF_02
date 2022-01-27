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


        Mannschaft heim = spiel.getHeim();
       int mannschaftsWertHeim = ermittelMannschaftsWert(heim);
       Mannschaft gast = spiel.getGast();
       int mannschaftsWertGast = ermittelMannschaftsWert(gast);

       int j = 0;
       for (int i = 0; i < spielZeit; i++){
           if (j + naechsteAktionZufall == i) {
               int summe = mannschaftsWertGast + mannschaftsWertHeim;

               int zufall = r.nextInt(summe);
               if (zufall > mannschaftsWertHeim) {
                   ArrayList<Spieler> gast_ = gast.getSpielerListe();
                   zufall = r.nextInt(gast_.size());
                   Spieler schuetze = gast_.get(zufall);
                   Torwart torwart = heim.getTorwart();
                   boolean tor = erzieltTor(schuetze, torwart);
                   System.out.println("Torschuss Gast");
                   if (tor) {
                       Ergebnis ergebnis = spiel.getErgebnis();
                       ergebnis.TrefferGast();
                       System.out.println("\nTreffer Gast");
                   }

               } else {
                   ArrayList<Spieler> heim_ = heim.getSpielerListe();
                   zufall = r.nextInt(heim_.size());
                   Spieler schuetze = heim_.get(zufall);
                   Torwart torwart = gast.getTorwart();
                   boolean tor = erzieltTor(schuetze, torwart);
                   System.out.println("Torschuss Heim");
                   if (tor) {
                       Ergebnis ergebnis = spiel.getErgebnis();
                       ergebnis.TrefferHeim();
                       System.out.println("\nTreffer Heim");
                   }
               }
               naechsteAktionZufall = r.nextInt(NAECHSTE_AKTION);
               j = i;
           }
       }
    }

}