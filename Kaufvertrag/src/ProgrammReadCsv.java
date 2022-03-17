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

        while ((zeile = br.readLine()) != null)
        {
            String[] array = zeile.split(";");
            System.out.println(zeile);
            System.out.println(array[0] + " | "+ array[1]+ " | "+ array[2]+ " | "+ array[3] +" | "+ array[4] + " | "+ array[5]);
            if (Objects.equals(array[0], "Verkäufer")){
                verkaeufer = new Vertragspartner(array[1], array[2]);
            }
            if (Objects.equals(array[0], "Käufer")){
                kaeufer = new Vertragspartner(array[1], array[2]);
            }
        }

        System.out.println(verkaeufer);
        System.out.println(kaeufer);
    }
}