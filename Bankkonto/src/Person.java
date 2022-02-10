public abstract class Person {
    private String name;
    private Adresse adresse;

    public Person(String name, Adresse adresse){
        this.adresse = adresse;
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
