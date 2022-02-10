public class Zauberer extends Spielfigur {
    private  int zauberpunkte;

    public Zauberer(int staerke, String name, int zauberpunkte) throws KeineKraftException {
        super(staerke,name);
        this.zauberpunkte = zauberpunkte;
    }

    public int getZauberpunkte(){
        return zauberpunkte;
    }

    public void trinkenZaubertrank(){
        zauberpunkte += 3;
    }

    public void zaubern() throws KeineKraftException {
       if (zauberpunkte >= 1) {
           zauberpunkte -= 1;
           System.out.println("Zaubert");
       }else{
            throw new KeineKraftException(getName(), "Zaubern");
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\n Zauberpunkte: " + getZauberpunkte();
    }
    public static boolean fehler(int zauberpunkte) {;
        if (zauberpunkte < 1) {
            return true;
        } else {
            return false;
        }
    }
}
