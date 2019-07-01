package lesson2;
import lombok.Data;
@Data

public class Dish {
   private final String name;

   private  final Integer calories;

   private final Boolean isBio;

   private static DishType type;
}
enum DishType {

    BEEF,

    CHICKEN,

    VEGETABLES

}

