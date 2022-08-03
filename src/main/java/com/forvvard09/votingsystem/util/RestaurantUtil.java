package com.forvvard09.votingsystem.util;

import com.forvvard09.votingsystem.model.MenuItem;
import com.forvvard09.votingsystem.model.Restaurant;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class RestaurantUtil {


    public static final List<MenuItem> listMenuOne = Arrays.asList(
            new MenuItem("Творожная запеканка", 750),
            new MenuItem("Омлет утренний", 99),
            new MenuItem("Пицца 250 гр", 800)
    );

    public static final List<MenuItem> listMenuTwo = Arrays.asList(
            new MenuItem("Уха", 250),
            new MenuItem("Креветки в азиатском соусе", 559),
            new MenuItem("Стейк из лосося с киноа", 699)
    );

    public static final List<MenuItem> listMenuThree = Arrays.asList(
            new MenuItem("Бефстроганов с картофелем", 599),
            new MenuItem("Борщ", 126)
    );


    public static final List<Restaurant> generateListTestData() {
        List<Restaurant> restaurants = Arrays.asList(
                new Restaurant("Теплица", LocalDateTime.of(2020, Month.JANUARY, 30, 12, 0)),
                new Restaurant("Озеро", LocalDateTime.of(2020, Month.JANUARY, 30, 13, 30)),
                new Restaurant("Кристина", LocalDateTime.of(2020, Month.JANUARY, 30, 18, 0)));

        restaurants.get(0).listMenuToMap(listMenuOne);
        restaurants.get(1).listMenuToMap(listMenuTwo);
        restaurants.get(2).listMenuToMap(listMenuThree);

        return restaurants;


    }
}
