package schritt1;

public class Spieler {

    private String name;
    private int alter;
    private int tore;
    private int staerke;
    private int torschuss;
    private int motivation;


    public Spieler(String name, int alter, int tore, int staerke, int torschuss, int motivation) {
        this.name = name;
        this.alter = alter;
        this.tore = tore;
        this.staerke = staerke;
        this.torschuss = torschuss;
        this.motivation = motivation;
    }

    @Override
    public String toString() {
        return "\nname: " + getName()
                + "\nalter: " + getAlter()
                + "\ntore: " + getTore()
                + "\nstaerke: " + getStaerke()
                + "\ntorschuss: " + getTorschuss()
                + "\nmotivation: " + getMotivation();
    }

    //getter


    public int getAlter() {
        return alter;
    }

    public int getTore() {
        return tore;
    }

    public String getName() {
        return name;
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

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }

    public void setName(String name) {
        this.name = name;
    }
}
