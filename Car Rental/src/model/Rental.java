package model;

public class Rental {

    private Customer customer;
    private Car car;
    private String pickDateAndTime;
    private int days;

    public Rental(Customer customer, Car car, int days, String pickDateAndTime) {
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.pickDateAndTime = pickDateAndTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getPickDateAndTime() {
        return pickDateAndTime;
    }

    public void setPickDateAndTime(String pickDateAndTime) {
        this.pickDateAndTime = pickDateAndTime;
    }
}
