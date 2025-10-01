package model;

public class Sedan extends CarType{

    public Sedan(String name) {
        super(name);
    }

    public Sedan(){
        super();
    }

    @Override
    public String toString() {
        return "[Sedan: " + name + "]";
    }
}
