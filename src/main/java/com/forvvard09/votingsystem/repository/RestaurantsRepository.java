package com.forvvard09.votingsystem.repository;

import com.forvvard09.votingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantsRepository {

    Restaurant get(int id);

    boolean save(Restaurant restaurant);

    boolean remove(int id);

    List<Restaurant> getAll();
}
