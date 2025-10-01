package model;

public class Car {

    private String carId;
    private CarType carType;
    private boolean isAvailable;
    private double basePrice;

    public Car(String carId, CarType carType, Double basePrice) {
        this.carId = carId;
        this.carType = carType;
        this.isAvailable = true;
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public double calculatePricePerDays(int days){
        return basePrice*days;
    }

    public void rent(){
        isAvailable = false;
    }


}
