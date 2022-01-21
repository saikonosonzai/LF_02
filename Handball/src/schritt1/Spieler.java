package schritt1;

import schritt3.Person;

public class Spieler extends Person {


    private int tore;
    private int staerke;
    private int torschuss;
    private int motivation;


    public Spieler(String name, int alter, int tore, int staerke, int torschuss, int motivation) {
       super(alter, name);
        this.tore = tore;
        this.staerke = staerke;
        this.torschuss = torschuss;
        this.motivation = motivation;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntore: " + getTore()
                + "\nstaerke: " + getStaerke()
                + "\ntorschuss: " + getTorschuss()
                + "\nmotivation: " + getMotivation();
    }

    //getter




    public int getTore() {
        return tore;
    }



    public int getStaerke() {
        return staerke;
    }

    public int getTorschuss() {
        return torschuss;
    }

    public int getMotivation() {
        return motivation;
    }

    //setter

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public void setTorschuss(int torschuss) {
        this.torschuss = torschuss;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }



    public void setTore(int tore) {
        this.tore = tore;
    }

}
