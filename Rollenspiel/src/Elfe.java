public class Elfe extends Spielfigur {

    public Elfe(int staerkePunkte, String name) throws KeineKraftException {
        super(staerkePunkte, name);
    }

    public void rennen() throws KeineKraftException {
        if (getStaerkepunkte() >= 2) {
            setStaerkepunkte(getStaerkepunkte() - 2);
            System.out.println("Klettert");
        }else{
            throw new KeineKraftException(getName(), "Klettern");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
