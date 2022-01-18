public class Programm {
    public static void main(String[] args) {
        System.out.println();

        Banane banane = new Banane();

        banane.setFarbe("Gelb");
        banane.setGewicht(128);
        banane.setReif(true);
        banane.setKruemmung(20);
        banane.setGeschmack("Süß");
        System.out.println(banane);

        System.out.println();
        System.out.println("=============");

        Apfel apfel = new Apfel();


        apfel.setWurm(true);
        apfel.setFarbe("Rot");
        apfel.setGewicht(250);
        apfel.setReif(true);
        apfel.setGeschmack("Sauer");

        System.out.println(apfel);

        System.out.println();
        System.out.println("=============");

        Kirsche kirsche = new Kirsche();
        kirsche.setFarbe("Rot");
        kirsche.setGewicht(7);
        kirsche.setReif(true);
        kirsche.setKerne(true);
        kirsche.setGeschmack("Sauer");
        System.out.println(kirsche);

        System.out.println();
        System.out.println("=============");

        Kiwi kiwi = new Kiwi();
        kiwi.setFarbe("Braun");
        kiwi.setGeschmack("Süß");
        kiwi.setGewicht(40);
        kiwi.setReif(true);
        System.out.println(kiwi);
    }
}
