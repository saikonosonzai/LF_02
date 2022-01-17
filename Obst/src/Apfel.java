public class Apfel extends Obst {

    private boolean wurm;

    public Apfel() {
        super("Apfel");

    }

    public String toString() {
        return super.toString() + "\nWurm: " + isWurm();
    }
    public void setWurm(boolean wurm) {
        this.wurm = wurm;
    }

    public boolean isWurm() {

        return wurm;
    }


}
