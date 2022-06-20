package com.forvvard09.votingsystem.repository;

import com.forvvard09.votingsystem.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRestaurants implements RestaurantsRepository {
    private final Map<Integer, Restaurant> repository = new HashMap<>();

    @Override
    public Restaurant get(int id) {
        return repository.getOrDefault(id, null);
    }

    @Override
    public boolean save(Restaurant restaurant) {
        //to do надо проверить
        return repository.computeIfAbsent(restaurant.getId(), value -> restaurant).equals(restaurant);
    }

    @Override
    public boolean remove(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(repository.values());
    }
}
