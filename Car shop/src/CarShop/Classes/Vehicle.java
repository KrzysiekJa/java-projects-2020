package CarShop.Classes;

public class Vehicle implements Comparable<Vehicle> {

    public Vehicle(String mark, String model, E_ItemCondition state, double price, int productionYear,
                   double mileage, double engineCapacity) {
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

    private String carShowroom;
    private final String mark;
    private final String model;
    private final E_ItemCondition state;
    private final double price;
    private final int productionYear;
    private final double mileage;
    private final double engineCapacity;
}
