import businessObjects.Vertragspartner;
import businessObjects.Ware;
import dataAccessObject.VertragspartnerDAO;
import dataAccessObject.WareDAO;

import java.util.ArrayList;


public class Programm {
    public static void main(String[] args) throws ClassNotFoundException {

        VertragspartnerDAO vertragspartnerDAO = new VertragspartnerDAO();
        Vertragspartner vertragspartner = vertragspartnerDAO.read("396435436439");
        System.out.println(vertragspartner);

        System.out.println("================================");

        WareDAO wareDAO = new WareDAO();
        Ware ware = wareDAO.read(1);
        System.out.println(ware);

        System.out.println("================================");

        VertragspartnerDAO vertragspartnerDAOAlle = new VertragspartnerDAO();
        ArrayList<Vertragspartner> vertragspartnerAlle = vertragspartnerDAOAlle.read();

        for (Vertragspartner v : vertragspartnerAlle) {
            System.out.println(v);
        }
    }
}
