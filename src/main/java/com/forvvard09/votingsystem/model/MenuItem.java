package com.forvvard09.votingsystem.model;

public class MenuItem {
    private final String nameDish;
    private final int cost;

    public MenuItem(String nameDish, int cost) {
        this.nameDish = nameDish;
        this.cost = cost;
    }

    public String getNameDish() {
        return nameDish;
    }

    public int getCost() {
        return cost;
    }

    public String getPrintFormat() {
        return String.format("%s - %s руб", nameDish, cost);
    }


}
