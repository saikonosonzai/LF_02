package schritt5;
import schritt1.Spieler;
import schritt2.Torwart;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.Random;
public class Gameplay {

    private static final int SPIELZEIT = 90;
    private static final int MAX_NACHSPIELZEIT = 5;
    private static final int MAX_DAUER_BIS_AKTION = 10;

    private static int ermittelMannschaftsWert(Mannschaft mannschaft){
       int mannschaftsWert =  mannschaft.getMotivation() * mannschaft.getStaerke() * mannschaft.getTrainer().getErfahrung();
       mannschaftsWert = Math.max(mannschaftsWert, 1);
        return mannschaftsWert;
    }

    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {
        Random r = new Random();
        int torschuss = schuetze.getTorschuss() +  r.nextInt(5) - 2;;
       torschuss = Math.max(torschuss,1);
        int reaktion = torwart.getReaktion() +  r.nextInt(5) - 2;;
        reaktion = Math.max(reaktion,1);
        if (torschuss > reaktion){
            return true;
        }else{
            return false;
        }
    }

    public static void spielen(Spiel spiel){
        Random r = new Random();
        int zahl = r.nextInt(MAX_NACHSPIELZEIT + 1);
        int spielZeit = SPIELZEIT + zahl;
        int naechsteAktionZufall = r.nextInt(MAX_DAUER_BIS_AKTION + 1);
        int spielDauer = naechsteAktionZufall;
do {
    int wertHeim = ermittelMannschaftsWert(spiel.getHeim());
    int wertGast = ermittelMannschaftsWert(spiel.getGast());
    int summe = wertGast + wertHeim;
    Mannschaft offensiv;
    Mannschaft defensiv;
    int zufall = r.nextInt(summe + 1);
    if (zufall > wertHeim){
        offensiv = spiel.getHeim();
        defensiv = spiel.getGast();
      
    }else{
        offensiv = spiel.getGast();
        defensiv = spiel.getHeim();

    }
    Spieler schuetze = offensiv.getSpielerListe().get(r.nextInt(offensiv.getSpielerListe().size()));
    Torwart torwart = defensiv.getTorwart();
    if (offensiv == spiel.getGast() && erzieltTor(schuetze, torwart)){
        spiel.getSpielbericht().append(spielDauer + ": Tor von " + schuetze.getName() + "!\n");
        spiel.getErgebnis().addToreGast();
        schuetze.setTore(+1);
    }else{
        if (offensiv == spiel.getHeim() && erzieltTor(schuetze, torwart)){
            spiel.getSpielbericht().append(spielDauer + ": Tor von " + schuetze.getName() + "!\n");
            spiel.getErgebnis().addToreHeim();
            schuetze.setTore(+1);
        }
    }
spielDauer +=  r.nextInt(MAX_DAUER_BIS_AKTION + 1);
}while(spielDauer < spielZeit);
    }
}