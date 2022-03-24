import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ProgrammReadCsv {
    public static void main(String[] args) throws IOException {
        String datei = "H:/Dokumente/Programmieren/PrintWriter/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));
        String zeile;
        Vertragspartner verkaeufer = null;
        Vertragspartner kaeufer = null;

        while ((zeile = br.readLine()) != null) {
            String strasse = "";
            String ort = "";
            String[] array = zeile.split(";");
            System.out.println(zeile);
            System.out.println();

            String[] name = array[1].split(" ");

            String[] StrasseHausNr = array[2].split(" ");
            for (int i = 0; i < StrasseHausNr.length - 1; i++) {
                strasse += StrasseHausNr[i] + " ";
            }
            String hausNr =  StrasseHausNr[StrasseHausNr.length - 1];
            strasse = strasse.trim();

            String[] PlzOrt = array[3].split(" ");
            for (int i = 1; i < PlzOrt.length; i++) {
                ort = PlzOrt[i] + " ";
            }
            String plz = PlzOrt[0];
            ort = ort.trim();

            if (Objects.equals(array[0], "Verkäufer")) {
                verkaeufer = new Vertragspartner(name[0], name[1]);
                verkaeufer.setAdresse(new Adresse(strasse, hausNr, plz, ort));
                verkaeufer.setAusweisNr(array[3]);
            }

            if (Objects.equals(array[0], "Käufer")) {
                kaeufer = new Vertragspartner(name[0], name[1]);
                kaeufer.setAdresse(new Adresse(strasse, hausNr , plz, ort));
                kaeufer.setAusweisNr(array[3]);
            }
        }

        System.out.println(verkaeufer);
        System.out.println(kaeufer);
    }
}