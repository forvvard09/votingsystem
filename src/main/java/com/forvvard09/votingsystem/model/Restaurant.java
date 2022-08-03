package com.forvvard09.votingsystem.model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {

    private Integer id;
    private final String name;
    private final int countLikes;
    private final LocalDateTime dateTimeEditMenu;
    private final Map<Integer, MenuItem> mapMenu;

    private final AtomicInteger counter = new AtomicInteger(0);


    public Restaurant(LocalDateTime dateTimeTo) {
        this(null, null, dateTimeTo, 0);
    }

    public Restaurant(String name, LocalDateTime dateTimeTo) {
        this(null, name, dateTimeTo, 0);
    }

    public Restaurant(Integer id, String name, LocalDateTime dateTimeEditMenu, Integer countLikes) {
        //Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(dateTimeEditMenu, "dateTimeTo must not be null");
        this.id = id;
        this.name = name;
        this.countLikes = countLikes;
        this.dateTimeEditMenu = dateTimeEditMenu;
        this.mapMenu = new ConcurrentHashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public LocalDateTime getDateTimeEditMenu() {
        return dateTimeEditMenu;
    }

    public Map<Integer, MenuItem> getMapMenu() {
        return Collections.unmodifiableMap(this.mapMenu);
    }

    public void addItemMenu(MenuItem menu) {
        this.mapMenu.put(generateIdItem(), menu);
    }

    public boolean isNew() {
        return id == null;
    }

    private int generateIdItem() {
        return counter.incrementAndGet();
    }

    public void listMenuToMap(List<MenuItem> listMenuItems) {
        for(MenuItem item : listMenuItems) {
            addItemMenu(item);
        }
    }
}
