package lesson2;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.val;
import lombok.Data;
@Data

public class Restaurant {
    private static List<Dish> menu;

    public static List<String>getLowestCalorieDishesInStream(List<Dish> menu){
        return  menu.stream().filter((p)->p.getCalories()<=400).map(p->p.getName()).collect(Collectors.toList());
    }
    public static List<String>getThreeMostHighCalorieDishesInStream(List<Dish> menu){
        return menu.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).map(p->p.getName()).limit(3).collect(Collectors.toList());
    }
    public static List<String> getSortedByTypeAndNameInStream(List<Dish> menu){
        return menu.stream().sorted(Comparator.comparing(Dish::getType).thenComparing(Dish::getName)).map(p->p.getName()).collect(Collectors.toList());
    }
    public static  Map<DishType, Double> getAverageCalorieByTypeInStream(List<Dish> menu){
        return menu.stream().sorted(Comparator.comparing(Dish::getType).reversed()).collect(Collectors.groupingBy(Dish::getType,Collectors.averagingDouble(Dish::getCalories)));
    }
    public static Map<DishType, List<Dish>>getGroupByDishesTypeInStream(List<Dish> menu){
        return menu.stream().collect(Collectors.groupingBy(Dish::getType));

    }
    public static Map<DishType, List<String>>getGroupBioDishesStream(List<Dish> menu){
        return menu.stream().filter(Dish::getIsBio).collect(Collectors.groupingBy(Dish::getType,Collectors.mapping(Dish::getName,Collectors.toList())));
    }

    public static List<String> getLowestCalorieDishes(List<Dish> menu) {
        List<String> lowestCalorieDishes = new ArrayList<>();
        for (Dish dish1 : menu) {
            if (dish1.getCalories() < 400) {
                lowestCalorieDishes.add(dish1.getName());
            }
        }
        return lowestCalorieDishes;
    }

    public static List<String> getThreeMostHighCalorieDishes(List<Dish> menu) {
        List<String> threeMostHighCalorieDishes = new ArrayList<>();
        Comparator<Dish> comparator = (o1, o2) -> o1.getCalories() - o2.getCalories();
        menu.sort(comparator.reversed());
        for (Dish dish : menu) {
            if (threeMostHighCalorieDishes.size() < 3) {
                threeMostHighCalorieDishes.add(dish.getName());
            }
        }
        return threeMostHighCalorieDishes;
    }

    public static List<String> getSortedByTypeAndName(List<Dish> menu) {
        List<String> sortedByTypeAndName = new ArrayList<>();
        menu.sort(Comparator.comparing(Dish::getType).thenComparing(Dish::getName));
        for (Dish dish : menu) {
            sortedByTypeAndName.add(dish.getName());
        }
        return sortedByTypeAndName;
    }

    public static List<Dish> getAllDishType(List<Dish> menu, DishType dishType) {
        List<Dish> allDishType = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getType() == dishType) {
                allDishType.add(dish);
            }
        }
        return allDishType;
    }

    public static int getHowManyDishInDishType(List<Dish> getAllDishType) {
        return getAllDishType.size();
    }

    public static int getHowManyCaloriesInDishType(List<Dish> getAllDishType) {
        int countCalories = 0;
        for (Dish dish : getAllDishType) {
            countCalories += dish.getCalories();
        }
        return countCalories;
    }

    public static double getAverageCaloriesDishInDishType(List<Dish> getAllDishType) {
        return getHowManyCaloriesInDishType(getAllDishType) / getHowManyDishInDishType(getAllDishType);
    }

    public static Map<DishType, List<Dish>>getMapGroupByDishesType(List<Dish> menu) {
        Map<DishType, List<Dish>> mapGroupByDishesType = new HashMap<>();
        for (Dish dish : menu) {
            DishType dishType = dish.getType();
            if (!mapGroupByDishesType.containsKey(dishType)) {
                List<Dish> dishList = new ArrayList<>();
                dishList.add(dish);
                mapGroupByDishesType.put(dishType, dishList);
            } else {
                List<Dish> dishList = mapGroupByDishesType.get(dishType);
                dishList.add(dish);
            }
        }
        return mapGroupByDishesType;
    }

    public static Map<DishType, List<String>> getMapGroupBioDishes(List<Dish> menu) {
        Map<DishType, List<String>> mapGroupBioDishes = new HashMap<>();
        for (Dish dish : menu) {
            if (dish.getIsBio() == true) {
                DishType dishType = dish.getType();
                if (!mapGroupBioDishes.containsKey(dishType)) {
                    List<String> stringList = new ArrayList<>();
                    stringList.add(dish.getName());
                    mapGroupBioDishes.put(dishType, stringList);
                } else {
                    List<String> stringList = mapGroupBioDishes.get(dishType);
                    stringList.add(dish.getName());
                }
            }
        }
        return mapGroupBioDishes;
    }
}



































