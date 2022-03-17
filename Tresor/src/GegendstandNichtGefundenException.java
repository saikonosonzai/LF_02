public class GegendstandNichtGefundenException extends Exception{
    private String id;

    public GegendstandNichtGefundenException(String id){
        this.id = id;
    }
    public String getMessage(){
        return "Es konnte kein Gegenstand mit der ID: "+ id+", gefunden werden";
    }
}
