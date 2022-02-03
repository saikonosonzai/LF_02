package schritt4;

public class Ergebnis {
    private int trefferHeim;
    private int trefferGast;

    @Override
    public String toString() {
        return "\ntrefferHeim: " + getTrefferHeim() +
                "\ntrefferGast: " + getTrefferGast();
    }

    public int getTrefferGast() {
        return trefferGast;
    }

    public void addToreGast() {
        trefferGast++;
    }

    public int getTrefferHeim() {
        return trefferHeim;
    }

    public void addToreHeim() {
        trefferHeim++;
    }
}
