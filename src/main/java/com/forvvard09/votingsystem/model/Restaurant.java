package com.forvvard09.votingsystem.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private  final String name;
    private final LocalDateTime dateTimeTo;
    private final int countLikes;
    private final List<Menu> listMenu = new ArrayList<>();


    /*
    public Restaurant() {

    }

    public Restaurant(String name) {
        this(name, );
    }
     */

    public Restaurant(String name, LocalDateTime dateTimeTo, List<Menu> listMenu) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(dateTimeTo, "dateTimeTo must not be null");
        this.name = name;
        this.dateTimeTo = dateTimeTo;
        this.countLikes = 0;
        this.listMenu.addAll(listMenu);
    }

    public void setMenuItem(Menu menu) {
        this.listMenu.add(menu);
    }
}
