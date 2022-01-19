public class Drachenfrucht extends Obst{

    private String fruchtfleisch;

    public Drachenfrucht(){
        super("Drachenfrucht");
    }

    public String getFruchtfleisch() {
        return fruchtfleisch;
    }

    public void setFruchtfleisch(String fruchtfleisch) {
        this.fruchtfleisch = fruchtfleisch;
    }

    public String toString(){
        return super.toString() + "\nFruchtfleisch: "+ getFruchtfleisch();
    }
}
