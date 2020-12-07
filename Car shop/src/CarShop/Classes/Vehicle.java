package CarShop.Classes;

import java.io.Serializable;


public class Vehicle implements Comparable<Vehicle>, Serializable {
    @CSVAnnatation
    private String carShowroom;
    @CSVAnnatation
    private final String mark;
    @CSVAnnatation
    private final String model;
    private transient final E_ItemCondition state;
    @CSVAnnatation
    private final double price;
    @CSVAnnatation
    private final int productionYear;
    @CSVAnnatation
    private final double mileage;
    @CSVAnnatation
    private final double engineCapacity;

    public Vehicle(String mark, String model, E_ItemCondition state, double price, int productionYear,
                   double mileage, double engineCapacity) {
        super();
        this.mark = mark;
        this.model = model;
        this.state = state;
        this.price = price;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
    }

    public void print() {
        System.out.println("Vehicle data: " + mark + " " + model);
        System.out.println("State: " + state);
        System.out.println("Price: " + price + " Year: " + productionYear);
        System.out.println("Mileage: " + mileage + " Capacity: " + engineCapacity);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.model.compareTo(o.model);
    }

    public String getMark() {
        return mark;
    }

    public double getPrice() {
        return price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public double getMileage() {
        return mileage;
    }

    public String getModel() {
        return model;
    }

    public E_ItemCondition getState() {
        return state;
    }

    public String getCarShowroom() {
        return carShowroom;
    }

    public void setCarShowroom(String carShowroom) {
        this.carShowroom = carShowroom;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "carShowroom='" + carShowroom + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", state=" + state +
                ", price=" + price +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
