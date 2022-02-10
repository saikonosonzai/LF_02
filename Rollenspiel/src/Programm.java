public class Programm {
    public static void main(String[] args) throws KeineKraftException {
        Elfe elfe = new Elfe(20,"Lego");
        Zauberer zauberer = new Zauberer(5,"Gandi",10);

        System.out.println(elfe);
        System.out.println(zauberer);
        try {
            elfe.rennen();
            zauberer.kaempfen();
            zauberer.zaubern();
            zauberer.zaubern();
            zauberer.zaubern();
        } catch (KeineKraftException e)
        {
            System.out.println(e.getMessage());
        }
    }

    }
