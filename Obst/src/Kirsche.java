public class Kirsche extends Obst {

    private boolean kerne;

    public Kirsche() {

        super("Kirsche");

    }
    public String toString() {
        return super.toString() + "\nKern: " + isKerne();
    }

    public boolean isKerne() {

        return kerne;
    }

    public void setKerne(boolean kerne) {

        this.kerne = kerne;
    }
}
