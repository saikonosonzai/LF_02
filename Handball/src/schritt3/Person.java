package schritt3;

public abstract class  Person{
    private int alter;
    private String name;

    public Person(int alter, String name){
        this.alter = alter;
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public String getName() {
        return name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setName(String name) {
        this.name = name;
    }
}