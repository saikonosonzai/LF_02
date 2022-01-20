package schritt2;

import schritt1.Spieler;

public class Torwart extends Spieler {
   private int reaktion;

public Torwart(String name, int alter, int staerke, int motivation, int reaktion){
    super(name, alter, 0, staerke, 0, motivation);
    this.reaktion = reaktion;
}

    @Override
    public String toString() {
        return super.toString() + "\nReaktion: "+ getReaktion();
    }

//getter

    public int getReaktion() {
        return reaktion;
    }
    //setter

    public void setReaktion(int reaktion) {
        this.reaktion = reaktion;
    }
}
