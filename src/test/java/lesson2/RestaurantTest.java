package lesson2;


import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class RestaurantTest {
    List<Dish> menu = Arrays.asList(new Dish("Mashed potatoes", 350, true, DishType.VEGETABLES),
            new Dish("Steamed vegetables", 250, true, DishType.VEGETABLES),
            new Dish("French fries", 600, false, DishType.VEGETABLES),
            new Dish("Boiled beef", 300, true, DishType.BEEF),
            new Dish("Beefsteak", 380, true, DishType.BEEF),
            new Dish("Baked chicken", 520, false, DishType.CHICKEN),
            new Dish("Chicken nuggets", 600, false, DishType.CHICKEN));
    @Test
    public void shouldGetLowestCalorieDishesInStream()throws Exception{
        List<String>lowCalories=Restaurant.getLowestCalorieDishesInStream(menu);
        List<String>actual=new ArrayList<>();
        actual.add("Mashed potatoes");
        actual.add("Steamed vegetables");
        actual.add("Boiled beef");
        actual.add("Beefsteak");
        Assertions.assertThat(actual).isEqualTo(lowCalories);

    }

    @Test
    public void shouldThreeMostHighCalorieDishesInStream()throws Exception {
        List<String>threeMostHighCalorie=Restaurant.getThreeMostHighCalorieDishesInStream(menu);
        List<String>actual=new ArrayList<>();
        actual.add("French fries");
        actual.add("Chicken nuggets");
        actual.add("Baked chicken");
        Assertions.assertThat(actual).isEqualTo(threeMostHighCalorie);
    }

    @Test
    public void shouldGetSortedByTypeAndNameInStream()throws Exception{
        List<String>sortedByTypeAndName=Restaurant.getSortedByTypeAndNameInStream(menu);
        List<String>actual=new ArrayList<>();
        actual.add("Beefsteak");
        actual.add("Boiled beef");
        actual.add("Baked chicken");
        actual.add("Chicken nuggets");
        actual.add("French fries");
        actual.add("Mashed potatoes");
        actual.add("Steamed vegetables");
        Assertions.assertThat(actual).isEqualTo(sortedByTypeAndName);
    }
    @Test
    public void shouldAverageCalorieByTypeStream()throws Exception{
        Map<DishType, Double>mapGetAverageCaloriesDishInDishType=Restaurant.getAverageCalorieByTypeInStream(menu);
        Map<DishType,Double>actual=new HashMap<>();
        actual.put(DishType.BEEF,340.0);
        actual.put(DishType.CHICKEN,560.0);
        actual.put(DishType.VEGETABLES,400.0);
        Assertions.assertThat(actual).isEqualTo(mapGetAverageCaloriesDishInDishType);
    }
    @Test
    public void shouldGroupByDishesTypeInStream()throws Exception{
        Map<DishType, List<Dish>> mapGroupByDishesType=Restaurant.getGroupByDishesTypeInStream(menu);
        Assertions.assertThat(mapGroupByDishesType).containsKeys(DishType.BEEF,DishType.VEGETABLES,DishType.CHICKEN);
        Map<DishType, List<Dish>> actual=new HashMap<>();
        actual.put(DishType.BEEF,Arrays.asList(new Dish("Boiled beef",300,true,DishType.BEEF),new Dish("Beefsteak",380,true,DishType.BEEF)));
        actual.put(DishType.VEGETABLES,Arrays.asList(new Dish("Mashed potatoes", 350, true, DishType.VEGETABLES),new Dish("Steamed vegetables", 250, true, DishType.VEGETABLES), new Dish("French fries", 600, false, DishType.VEGETABLES)));
        actual.put(DishType.CHICKEN,Arrays.asList(new Dish("Baked chicken", 520, false, DishType.CHICKEN),new Dish("Chicken nuggets", 600, false, DishType.CHICKEN)));
        Assertions.assertThat(actual).isEqualTo(mapGroupByDishesType);
    }
    @Test
    public void groupBioDishesStream()throws Exception{
        Map<DishType, List<String>> mapGroupBioDishes=Restaurant.getGroupBioDishesStream(menu);
        Map<DishType, List<String>>actual=new HashMap<>();
        actual.put(DishType.VEGETABLES,Arrays.asList("Mashed potatoes","Steamed vegetables"));
        actual.put(DishType.BEEF,Arrays.asList("Boiled beef","Beefsteak"));
        Assertions.assertThat(actual).isEqualTo(mapGroupBioDishes);
    }
    @Test
    public void shouldLowestCalorieDishes()throws Exception{
        List<String>lowCalories=Restaurant.getLowestCalorieDishes(menu);
        System.out.println(lowCalories);
        List<String>actual=new ArrayList<>();
        actual.add("Mashed potatoes");
        actual.add("Steamed vegetables");
        actual.add("Boiled beef");
        actual.add("Beefsteak");
        Assertions.assertThat(actual).isEqualTo(lowCalories);
    }
    @Test
    public void shouldThreeMostHighCalorieDishes()throws Exception{
        List<String>threeMostHighCalorie=Restaurant.getThreeMostHighCalorieDishes(menu);
        System.out.println(threeMostHighCalorie);
        List<String>actual=new ArrayList<>();
        actual.add("French fries");
        actual.add("Chicken nuggets");
        actual.add("Baked chicken");
        Assertions.assertThat(actual).isEqualTo(threeMostHighCalorie);
    }
    @Test
    public void shouldSortedByTypeAndName()throws Exception{
       List<String>sortedByTypeAndName=Restaurant.getSortedByTypeAndName(menu);
        System.out.println(sortedByTypeAndName);
        List<String>actual=new ArrayList<>();
        actual.add("Beefsteak");
        actual.add("Boiled beef");
        actual.add("Baked chicken");
        actual.add("Chicken nuggets");
        actual.add("French fries");
        actual.add("Mashed potatoes");
        actual.add("Steamed vegetables");
        Assertions.assertThat(actual).isEqualTo(sortedByTypeAndName);
    }
    @Test
    public void shouldGetAllDishType()throws Exception{
        List<Dish>allDishTyp=Restaurant.getAllDishType(menu,DishType.BEEF);
        List<Object>actual=new ArrayList<>();
        actual.add(new Dish("Boiled beef",300,true,DishType.BEEF));
        actual.add(new Dish("Beefsteak",380,true,DishType.BEEF));
        Assertions.assertThat(actual).isEqualTo(allDishTyp);
    }
    @Test
    public void shouldGetHowManyDishInDishType()throws Exception{
        int number=Restaurant.getHowManyDishInDishType(Restaurant.getAllDishType(menu,DishType.BEEF));
        Assert.assertEquals(number,2);
    }
    @Test
    public void shouldGetHowManyCaloriesInDishType()throws Exception{
        int count=Restaurant.getHowManyCaloriesInDishType(Restaurant.getAllDishType(menu,DishType.BEEF));
        Assert.assertEquals(count,680);
    }
    @Test
    public void shouldGetAverageCaloriesDishInDishType()throws Exception{
        double average=Restaurant.getAverageCaloriesDishInDishType(Restaurant.getAllDishType(menu,DishType.BEEF));
        double average1=Restaurant.getAverageCaloriesDishInDishType(Restaurant.getAllDishType(menu,DishType.CHICKEN));
        double average2=Restaurant.getAverageCaloriesDishInDishType(Restaurant.getAllDishType(menu,DishType.VEGETABLES));
        Map<DishType, Double>mapGetAverageCaloriesDishInDishType=new HashMap<>();
        mapGetAverageCaloriesDishInDishType.put(DishType.BEEF,average);
        mapGetAverageCaloriesDishInDishType.put(DishType.CHICKEN,average1);
        mapGetAverageCaloriesDishInDishType.put(DishType.VEGETABLES,average2);
        Map<DishType,Double>actual=new HashMap<>();
        actual.put(DishType.BEEF,340.0);
        actual.put(DishType.CHICKEN,560.0);
        actual.put(DishType.VEGETABLES,400.0);
        Assertions.assertThat(actual).isEqualTo(mapGetAverageCaloriesDishInDishType);
    }
    @Test
    public void shouldGetMapGroupByDishesType()throws Exception{
        Map<DishType, List<Dish>> mapGroupByDishesType=Restaurant.getMapGroupByDishesType(menu);
        Assertions.assertThat(mapGroupByDishesType).containsKeys(DishType.BEEF,DishType.VEGETABLES,DishType.CHICKEN);
        Map<DishType, List<Dish>> actual=new HashMap<>();
        actual.put(DishType.BEEF,Arrays.asList(new Dish("Boiled beef",300,true,DishType.BEEF),new Dish("Beefsteak",380,true,DishType.BEEF)));
        actual.put(DishType.VEGETABLES,Arrays.asList(new Dish("Mashed potatoes", 350, true, DishType.VEGETABLES),new Dish("Steamed vegetables", 250, true, DishType.VEGETABLES), new Dish("French fries", 600, false, DishType.VEGETABLES)));
        actual.put(DishType.CHICKEN,Arrays.asList(new Dish("Baked chicken", 520, false, DishType.CHICKEN),new Dish("Chicken nuggets", 600, false, DishType.CHICKEN)));
        Assertions.assertThat(actual).isEqualTo(mapGroupByDishesType);
    }
    @Test
    public void shouldGetMapGroupBioDishes()throws Exception{
        Map<DishType, List<String>> mapGroupBioDishes=Restaurant.getMapGroupBioDishes(menu);
        Map<DishType, List<String>>actual=new HashMap<>();
        actual.put(DishType.VEGETABLES,Arrays.asList("Mashed potatoes","Steamed vegetables"));
        actual.put(DishType.BEEF,Arrays.asList("Boiled beef","Beefsteak"));
        Assertions.assertThat(actual).isEqualTo(mapGroupBioDishes);
    }
}















