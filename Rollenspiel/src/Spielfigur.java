import java.util.Random;

public abstract class Spielfigur  {
    private int staerkepunkte;
    private String name;
    private int leben;

    public Spielfigur(int staerke, String name) throws KeineKraftException{
        this.name = name;
        this.staerkepunkte = staerke;
        this.leben = leben;
    }

    public void laufen() throws KeineKraftException{
        if (staerkepunkte >= 1) {
            staerkepunkte -= 1;
            System.out.println("Läuft");
        }else{
            throw new KeineKraftException(getName(), "Laufen");
        }
    }
    public void klettern() throws KeineKraftException {
        if (staerkepunkte >= 2) {
            staerkepunkte -= 2;
            System.out.println("Klettert");
        }else{
            throw new KeineKraftException(getName(), "Klettern");
        }
    }
    public void kaempfen() throws KeineKraftException {
        if (staerkepunkte >= 3) {
            staerkepunkte -= 3;
            System.out.println("Kämpft");
        }else{
            throw new KeineKraftException(getName(), "Kämpfen");
        }
    }

    public void essen(){
        staerkepunkte += 10;
    }


    public int getStaerkepunkte() {
        return staerkepunkte;
    }
    public String getName() {
        return name;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setStaerkepunkte(int staerkepunkte) {
        this.staerkepunkte = staerkepunkte;
    }

    public static boolean fehler(int staerkepunkte) {
        if (staerkepunkte < 1) {
            return true;
        } else {
            return false;
        }
    }

        @Override
        public String toString () {
            return "\nstaerke: " + staerkepunkte +
                    "\nname: " + name;
        }
}
