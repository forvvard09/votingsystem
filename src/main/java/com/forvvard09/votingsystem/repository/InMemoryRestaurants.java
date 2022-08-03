package com.forvvard09.votingsystem.repository;

import com.forvvard09.votingsystem.model.Restaurant;
import com.forvvard09.votingsystem.util.RestaurantUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRestaurants implements RestaurantsRepository {

    private static volatile InMemoryRestaurants instance;

    private final Map<Integer, Restaurant> repository = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    {
        RestaurantUtil.generateListTestData().forEach(this::save);
        /*
        for(Restaurant rest: RestaurantUtil.restaurants) {
            this.save(rest);
        }
         */
    }

    public static InMemoryRestaurants getInstance() {
        InMemoryRestaurants localInstance = instance;
        if (localInstance == null) {
            synchronized (InMemoryRestaurants.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new InMemoryRestaurants();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Restaurant get(int id) {
        return repository.getOrDefault(id, null);
    }

    @Override
    public boolean save(Restaurant rest) {
        if (rest.isNew()) {
            rest.setId(counter.incrementAndGet());
        }
        return repository.computeIfAbsent(rest.getId(), value -> rest).equals(rest);
    }

    /*
    @Override
    public Restaurant save(Restaurant rest) {
        if (rest.isNew()) {
            rest.setId(counter.incrementAndGet());
            repository.put(rest.getId(), rest);
            return rest;
        }
        // handle case: update, but not present in storage
        return repository.computeIfPresent(rest.getId(), (id, oldMeal) -> rest);
    }
     */

    @Override
    public boolean remove(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(repository.values());
    }
}
