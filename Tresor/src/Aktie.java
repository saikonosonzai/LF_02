public class Aktie extends Gegenstand{
    private String unternehmen;
    private double nennWert;

    public Aktie(String id, double wert, String unternehmen, double nennWert){
        super(id, wert);
        this.nennWert = nennWert;
        this.unternehmen = unternehmen;
    }

    public String getUnternehmen() {
        return unternehmen;
    }

    public double getNennWert() {
        return nennWert;
    }

    public void setNennWert(double nennWert) {
        this.nennWert = nennWert;
    }

    public void setUnternehmen(String unternehmen) {
        this.unternehmen = unternehmen;
    }

    @Override
    public String toString() {
        return super.toString()  + " unternehmen: " + unternehmen + " nennWert:" + nennWert;
    }
}
