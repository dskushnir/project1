package lesson2;
import lombok.Data;
@Data

public class Dish implements Comparable<Dish>{
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

    @Override
    public int compareTo(Dish o) {
        return calories.compareTo(o.getCalories());
    }
}


    enum DishType {

        BEEF,

        CHICKEN,

        VEGETABLES;


    }







