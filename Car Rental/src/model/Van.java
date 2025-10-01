package model;

public class Van extends CarType{
    public Van(String name) {
        super(name);
    }
    public Van(){
        super();
    }
    @Override
    public String toString() {
        return "[Van: " + name+ "]";
    }
}
