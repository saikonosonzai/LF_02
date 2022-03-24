import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.property.TextAlignment;
import java.io.IOException;
import java.util.ArrayList;

public class ProgrammWritePDF {


    public static void main(String[] args) throws IOException {

        Kaufvertrag kaufvertrag = erstellenKaufvertrag();
        SchreibenPDF(kaufvertrag);

    }


    public static void SchreibenPDF(Kaufvertrag vertrag) throws IOException {
        String datei = "H:/Dokumente/Programmieren/PrintWriter/Kaufvertrag.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        document.setFont(font);
        Style style = new Style();
        style.setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN));
        style.setFontSize(12);
        Style styleSpecial = new Style();
        PdfFont pdfFontspecial = PdfFontFactory.createFont(StandardFonts.COURIER);
        styleSpecial.setFont(pdfFontspecial).setFontSize(12);


        Cell Ueberschrift = new Cell();
        Ueberschrift.setTextAlignment(TextAlignment.CENTER);
        Ueberschrift.add(new Paragraph("Kaufvertrag").setBackgroundColor(ColorConstants.LIGHT_GRAY).setFontColor(new DeviceRgb(0,100,150)).setFontSize(30));

        document.add(Ueberschrift);

        Paragraph pKaeufer = new Paragraph();


        pKaeufer.add(new Text("Käufer:\n").setUnderline().setFontColor(ColorConstants.GREEN).setFontSize(16));
        document.add(pKaeufer);


        List listKaeufer = new List();
        listKaeufer.setListSymbol("- ");
        listKaeufer.add(vertrag.getKaeufer().getVorname() + " " + vertrag.getKaeufer().getNachname() + "\n");
        listKaeufer.add(vertrag.getKaeufer().getAdresse().getStrasse() + " " + vertrag.getKaeufer().getAdresse().getHausNr() + " "
                + vertrag.getKaeufer().getAdresse().getPlz() + " " + vertrag.getKaeufer().getAdresse().getOrt() + "\n");
        listKaeufer.add(vertrag.getKaeufer().getAusweisNr());

        document.add(listKaeufer);

        Paragraph pVerkaeufer = new Paragraph();

        pVerkaeufer.add(new Text("Verkäufer:\n").setFontColor(ColorConstants.RED).setUnderline().setFontSize(16));
        document.add(pVerkaeufer);

        List listVerkaeufer = new List();

        listVerkaeufer.setListSymbol("- ");
        listVerkaeufer.add(vertrag.getVerkaeufer().getVorname() + " " + vertrag.getVerkaeufer().getNachname());
        listVerkaeufer.add(vertrag.getVerkaeufer().getAdresse().getStrasse() + " " + vertrag.getVerkaeufer().getAdresse().getHausNr() + " "
                + vertrag.getVerkaeufer().getAdresse().getPlz() + " " + vertrag.getVerkaeufer().getAdresse().getOrt());
        listVerkaeufer.add(vertrag.getVerkaeufer().getAusweisNr());
        document.add(listVerkaeufer);


        Paragraph pWare = new Paragraph();

        pWare.add(new Text("\nVerkaufte Ware:\n").setUnderline().setFontColor(ColorConstants.BLUE));

        Table tableWare = new Table( 2);
        tableWare.useAllAvailableWidth();

        Cell headerl = new Cell();
        headerl.add(new Paragraph("Text"));
        headerl.setTextAlignment(TextAlignment.LEFT);
        tableWare.addHeaderCell(headerl); Cell header2 = new Cell();
        header2.add(new Paragraph( "Wert"));
        header2.setTextAlignment(TextAlignment.LEFT);
        tableWare.addHeaderCell(header2);


        tableWare.addCell("Bezeichnung");
        tableWare.addCell(vertrag.getWare().getBezeichnung());
        tableWare.addCell("Beschreibung");
        tableWare.addCell(vertrag.getWare().getBeschreibung());
        tableWare.addCell("Preis");
        tableWare.addCell(""+ vertrag.getWare().getPreis());
        tableWare.addCell("Besonderheiten");
        ArrayList<String> besonderheiten = vertrag.getWare().getBesonderheiten();
        tableWare.addCell(String.valueOf(besonderheiten));
        tableWare.addCell("Mängel");
        ArrayList<String> maengel = vertrag.getWare().getMaengel();
        tableWare.addCell(String.valueOf(maengel));

        document.add(pWare);
        document.add(tableWare);

        Paragraph pZahlung = new Paragraph();
        pZahlung.add(new Text("\nZahlungsmodalitäten:\n").setFontSize(16).setUnderline().setFontColor(ColorConstants.LIGHT_GRAY));
        pZahlung.add(vertrag.getZahlungsModalitaeten());
        document.add(pZahlung);
        document.close();
    }

    public static Kaufvertrag erstellenKaufvertrag() {
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
