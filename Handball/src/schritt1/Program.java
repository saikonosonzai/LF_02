package schritt1;

public class Program {
    public static void main(String[] args) {

        Trainer trainer = new Trainer("Hans", 30, 7);
        System.out.println(trainer);


        trainer.setAlter(40);
        trainer.setName("Otto");
        trainer.setErfahrung(2);

        System.out.println(trainer);


        System.out.println();
        System.out.println("===========");
        System.out.println();

        Spieler spieler = new Spieler("Hannes", 25, 3, 8, 6, 2);
        System.out.println(spieler);


        spieler.setAlter(40);
        spieler.setName("Johannes");
        spieler.setMotivation(2);
        spieler.setTore(30);
        spieler.setStaerke(10);
        spieler.setTorschuss(2);

        System.out.println(spieler);

    }
}
