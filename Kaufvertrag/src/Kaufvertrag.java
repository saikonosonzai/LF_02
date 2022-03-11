public class Kaufvertrag {
    private Vertragspartner kaeufer;
    private Vertragspartner verkaeufer;
    private Ware ware;
    private String zahlungsModalitaeten;

    public Kaufvertrag(Vertragspartner kaeufer, Vertragspartner verkaeufer, Ware ware, String zahlungsModalitaeten){
        this.kaeufer = kaeufer;
        this.verkaeufer = verkaeufer;
        this.ware = ware;
        this.zahlungsModalitaeten = zahlungsModalitaeten;
    }

    public String getZahlungsModalitaeten() {
        return zahlungsModalitaeten;
    }

    public Vertragspartner getKaeufer() {
        return kaeufer;
    }

    public Vertragspartner getVerkaeufer() {
        return verkaeufer;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public void setVerkaeufer(Vertragspartner verkaeufer) {
        this.verkaeufer = verkaeufer;
    }

    public void setKaeufer(Vertragspartner kaeufer) {
        this.kaeufer = kaeufer;
    }

    public void setZahlungsModalitaeten(String zahlungsModalitaeten) {
        this.zahlungsModalitaeten = zahlungsModalitaeten;
    }

    @Override
    public String toString() {
        return "Kaufvertrag{" +
                "kaeufer=" + kaeufer +
                ", verkaeufer=" + verkaeufer +
                ", ware=" + ware +
                ", zahlungsModalitaeten='" + zahlungsModalitaeten + '\'' +
                '}';
    }
}
