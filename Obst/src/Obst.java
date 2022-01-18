public abstract class Obst {

    private String name;
    private String farbe;
    private double gewicht;
    private boolean reif;
    private String geschmack;

    public Obst(String name) {

        this.name = name;

    }

    public String getName() {

        return name;
    }

    public String getFarbe() {

        return farbe;
    }

    public void setFarbe(String farbe) {

        this.farbe = farbe;
    }

    public double getGewicht() {

        return gewicht;
    }

    public void setGewicht(double gewicht) {

        this.gewicht = gewicht;
    }

    public boolean isReif() {

        return reif;
    }

    public void setReif(boolean reif) {

        this.reif = reif;
    }

    public String getGeschmack() {
        return geschmack;
    }

    public void setGeschmack(String geschmack) {
        this.geschmack = geschmack;
    }

    public String toString(){
        String text = "";
        text += "\nName: "+ getName();
        text += "\nFarbe: " + getFarbe();
        text += "\nGewicht: "+ getGewicht()+"g";
        text += "\nreif: "+ isReif();
        text += "\nGeschmack: "+getGeschmack();
        return text;
    }
}
