package schritt5;
import schritt1.Spieler;
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
        int zahl = r.nextInt(NACH_SPIEL_ZEIT + 1);
        int spielZeit = SPIELZEIT + zahl;
        int naechsteAktionZufall = r.nextInt(NAECHSTE_AKTION + 1);
        spielZeit -= naechsteAktionZufall;
do {

    int mannschaftsWertHeim = ermittelMannschaftsWert(spiel.getHeim());
    int mannschaftsWertGast = ermittelMannschaftsWert(spiel.getGast());
    int summe = mannschaftsWertGast + mannschaftsWertHeim;
    Mannschaft offensiv;
    Mannschaft defensiv;
    int zufall = r.nextInt(summe + 1);
    if (zufall > mannschaftsWertHeim){
        offensiv = spiel.getHeim();
        defensiv = spiel.getGast();
        System.out.println("Torschuss heim bei min: "+spielZeit);
    }else{
        offensiv = spiel.getGast();
        defensiv = spiel.getHeim();
        System.out.println("Torschuss gast bei min: "+spielZeit);
    }
    Ergebnis ergebnis = spiel.getErgebnis();
    ArrayList<Spieler> spielerArrayList = offensiv.getSpielerListe();
    Spieler schuetze = spielerArrayList.get(r.nextInt(spielerArrayList.size()));
    Torwart torwart = defensiv.getTorwart();
    if (offensiv == spiel.getGast() && erzieltTor(schuetze, torwart)){
        System.out.println("Treffer Gast");
        ergebnis.TrefferGast();
        schuetze.setTore(+1);
    }else{
        if (offensiv == spiel.getHeim() && erzieltTor(schuetze, torwart)){
            System.out.println("Treffer heim");
            ergebnis.TrefferHeim();
            schuetze.setTore(+1);
        }
    }
spielZeit -=  r.nextInt(NAECHSTE_AKTION + 1);
}while(spielZeit > 0);
    }
}