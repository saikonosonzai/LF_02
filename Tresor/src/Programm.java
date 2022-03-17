import java.util.ArrayList;

public class Programm {
    public static void main(String[] args)  {
        Aktie aktie = new Aktie("12345",20,"Microsoft", 20);
        Schmuck schmuck = new Schmuck("54321",30,"Kette");
        ArrayList<Gegenstand> gegenstandArrayList = new ArrayList<>();
        Tresor tresor = new Tresor(gegenstandArrayList);

        tresor.hinzufuegen(schmuck);
        tresor.hinzufuegen(aktie);

        System.out.println(tresor.summeWert());

        for (int i = 0; i < 2; i++) {
            try {
                tresor.entfernen("12345");
            } catch (GegendstandNichtGefundenException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println(tresor.summeWert());

    }
}
