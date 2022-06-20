package com.forvvard09.votingsystem;

import com.forvvard09.votingsystem.model.Menu;
import com.forvvard09.votingsystem.model.Restaurant;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menuList = Arrays.asList(
                new Menu("Твороженная запеканка", 7500),
                new Menu("Борщ", 12600),
                new Menu("Омлет", 8900)
        );

        Restaurant restaurant = new Restaurant(99,"Теплица", LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), menuList);
        restaurant.setMenuItem(new Menu("Салат Цезарь", 14300));
    }
}
