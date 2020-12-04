package CarShop.Classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VehicleAnnatation {
    String carShowroom();
    String mark();
    String model();
    E_ItemCondition state() default E_ItemCondition.NEW;
    double price();
    int productionYear();
    double mileage();
    double engineCapacity();
}
