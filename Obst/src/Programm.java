public class Programm {
    public static void main(String[] args) {
        System.out.println();

        Banane banane = new Banane();

        banane.setFarbe("Gelb");
        banane.setGewicht(128);
        banane.setReif(true);
        banane.setKruemmung(20);
        System.out.println(banane);

        System.out.println("=============");

        Obst apfel = new Apfel();
        
        apfel.setFarbe("Rot");
        apfel.setGewicht(250);
        apfel.setReif(true);

        System.out.println(apfel);




    }
}
