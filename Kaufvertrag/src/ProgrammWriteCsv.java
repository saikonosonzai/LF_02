import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class ProgrammWriteCsv {
    public static void main(String[] args) throws FileNotFoundException {

        Kaufvertrag kaufvertrag = erstellenKaufvertrag();
        SchreibenCsv(kaufvertrag);

    }

    public static void SchreibenCsv(Kaufvertrag vertrag) throws FileNotFoundException {
        String datei = "H:/Dokumente/Programmieren/PrintWriter/Kaufvertrag.csv";
        PrintWriter writer = new PrintWriter(datei);
        writer.print("Vertragspartner;");
        writer.print("Vorname Nachname;");
        writer.print("Straße HausNr;");
        writer.print("PLZ Ort;");
        writer.println("AusweisNr;");

        writer.print("Verkäufer;");
        writer.print(vertrag.getVerkaeufer().getVorname()+" "+vertrag.getVerkaeufer().getNachname()+";");
        writer.print(vertrag.getVerkaeufer().getAdresse().getStrasse() + " " + vertrag.getVerkaeufer().getAdresse().getHausNr() + ";"
                + vertrag.getVerkaeufer().getAdresse().getPlz() + " " +  vertrag.getVerkaeufer().getAdresse().getOrt() +";");
        writer.println(vertrag.getVerkaeufer().getAusweisNr()+";");

        writer.print("Käufer;");
        writer.print(vertrag.getKaeufer().getVorname()+" "+vertrag.getVerkaeufer().getNachname()+";");
        writer.print(vertrag.getKaeufer().getAdresse().getStrasse() + " " + vertrag.getKaeufer().getAdresse().getHausNr() + ";"
                + vertrag.getKaeufer().getAdresse().getPlz() + " " +  vertrag.getKaeufer().getAdresse().getOrt() +";");
        writer.println(vertrag.getKaeufer().getAusweisNr()+";");
        writer.close();

    }

    public static Kaufvertrag erstellenKaufvertrag(){
        Ware ware = new Ware("Laptop", 250.0);
        ware.setBeschreibung("Super krasses Gaming-Laptop");
        ware.getBesonderheiten().add("Tasche");
        ware.getBesonderheiten().add("Gaming-Maus");
        ware.getMaengel().add("Ladekabel fehlt");
        ware.getMaengel().add("Touchpad defekt");

        Vertragspartner kaeufer = new Vertragspartner("Klaus", "Brandt");
        kaeufer.setAusweisNr("0123456789");
        kaeufer.setAdresse(new Adresse("Zu Hause", "3a", "28199", "Bremen"));

        Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Auch zu Hause", "7", "28195", "Bremen"));

        Kaufvertrag vertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        vertrag.setZahlungsModalitaeten("Privater Barverkauf");

        System.out.println(vertrag);

        return vertrag;
    }
}

