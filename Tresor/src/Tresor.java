import java.util.ArrayList;
import java.util.Objects;

public class Tresor {

    private ArrayList<Gegenstand> gegenstandArrayList;

    public Tresor(ArrayList<Gegenstand> gegenstandArrayList){
        this.gegenstandArrayList = gegenstandArrayList;
    }

    public Gegenstand getGegenstand(String id) {
        Gegenstand gegenstand = null;
        for (Gegenstand g : gegenstandArrayList) {
            if (Objects.equals(g.getiD(), id)) {
                gegenstand = g;

            }
        }
        return gegenstand;
    }

    public void hinzufuegen(Gegenstand gegenstand){
        gegenstandArrayList.add(gegenstand);
    }

    public void entfernen(String id) throws GegendstandNichtGefundenException{
        Gegenstand gegenstand = getGegenstand(id);
                if (gegenstandArrayList.contains(gegenstand)) {
                    gegenstandArrayList.remove(gegenstand);
                    System.out.println("Der Gegenstand  " + gegenstand + ", wurde entfernt");
                }else{
                    throw new GegendstandNichtGefundenException(id);
                }
               }

    public double summeWert(){
        double summeWert = 0;
        for(Gegenstand g :gegenstandArrayList){
            summeWert += g.getWert();
            }
        return summeWert;
    }
}
