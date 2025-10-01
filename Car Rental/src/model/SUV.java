package model;

public class SUV extends CarType{

    public SUV(String name) {
        super(name);
    }
    public SUV(){
        super();
    }

    @Override
    public String toString() {
        return "[SUV: " + name+ "]";
    }
}
