package lesson2;
import lombok.Data;
@Data

public class Dish {
    private final String name;
    private final Integer calories;
    private final Boolean isBio;
    private DishType type;

    public Dish(String name, Integer calories, Boolean isBio, DishType type) {
        this.name = name;
        this.calories = calories;
        this.isBio = isBio;
        this.type = type;
    }
}
    enum DishType {

        BEEF,

        CHICKEN,

        VEGETABLES

    }







