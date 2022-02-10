package schritt6;

import java.util.Random;

public class SpielAbbruchException extends Exception{

    private int spielDauer;
public SpielAbbruchException(int spielDauer) {
    this.spielDauer = spielDauer;
}

    public int getSpielDauer() {
        return spielDauer;
    }

    @Override
    public String getMessage(){
    return "Spiel wird Abgebrochen min: "+ getSpielDauer();
    }


}
