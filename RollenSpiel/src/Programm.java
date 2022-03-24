public class Programm {
    public static void main(String[] args) {
        Elfe elfe1 = new Elfe("Tom", 20);
        Zauberer zauberer1 = new Zauberer("Lehrling", 7, 5);

        try {
            elfe1.kaempfen(zauberer1);
        } catch (KeineKraftException e) {
            System.out.println(e.getMessage());
        }
        try {
            elfe1.kaempfen(zauberer1);
        } catch (KeineKraftException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("===================================");
    }
}
