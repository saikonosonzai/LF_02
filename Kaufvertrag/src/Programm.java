import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import dataAccessObject.VertragspartnerDAO;
import dataAccessObject.WareDAO;

import java.sql.SQLException;
import java.util.ArrayList;


public class Programm {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        VertragspartnerDAO vertragspartnerDAO = new VertragspartnerDAO();
       Vertragspartner vertragspartner = vertragspartnerDAO.read("1");
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


        Vertragspartner vertragspartner1 = new Vertragspartner("noah", "härtel");
        vertragspartner1.setAusweisNr("2");
        vertragspartner1.setAdresse(new Adresse("vizk","b","c","d"));
        //vertragspartnerDAO.insert(vertragspartner1);
        vertragspartnerDAO.update("2",vertragspartner1);

        //vertragspartnerDAO.delete("1");
    }
}
