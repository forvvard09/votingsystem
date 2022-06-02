package com.forvvard09.votingsystem.model;

public class Menu {
    private final String nameDish;
    private final int cost;

    public Menu(String nameDish, int cost) {
        this.nameDish = nameDish;
        this.cost = cost;
    }

    public String getNameDish() {
        return nameDish;
    }

    public int getCost() {
        return cost;
    }
}
