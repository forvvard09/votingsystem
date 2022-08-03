package com.forvvard09.votingsystem;

import com.forvvard09.votingsystem.repository.InMemoryRestaurants;
import com.forvvard09.votingsystem.repository.RestaurantsRepository;


public class Main {
    public static void main(String[] args) {

        RestaurantsRepository repository;
        repository = new InMemoryRestaurants();

        repository.getAll().forEach(System.out::println);
        //System.out.println(repository.getAll());

    }

}
