public class Programm {
    public static void main(String[] args) {

        Obst apfel = new Apfel();

        apfel.setFarbe("Rot");
        apfel.setGewicht(250);
        apfel.setReif(true);

        System.out.println("Dieses Obst heißt: "+apfel.getName());
        System.out.println("Er hat die Farbe: "+apfel.getFarbe());
        System.out.println("Er hat ein Gewicht von: "+apfel.getGewicht()+"g");
        System.out.println("Ist er Reif?: "+apfel.isReif());

        System.out.println();

        Banane banane = new Banane();

        banane.setKruemmung(20);
        System.out.println("Dieses Obst heißt: "+banane.getName());
        System.out.println("Sie hat eine Krümmung von: "+banane.getKruemmung()+"°");
    }
}
