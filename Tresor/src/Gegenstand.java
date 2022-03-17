public abstract class Gegenstand {
    private String iD;
    private double wert;

    Gegenstand(String iD, double wert){
        this.iD = iD;
        this.wert = wert;
    }

    public double getWert() {
        return wert;
    }

    public String getiD() {
        return iD;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        return "ID: " + iD+
                " wert: " + wert;
    }
}
