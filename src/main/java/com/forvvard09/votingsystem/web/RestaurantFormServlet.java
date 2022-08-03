package com.forvvard09.votingsystem.web;

import com.forvvard09.votingsystem.model.Restaurant;
import com.forvvard09.votingsystem.repository.InMemoryRestaurants;
import com.forvvard09.votingsystem.repository.RestaurantsRepository;
import org.slf4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

public class RestaurantFormServlet extends HttpServlet {
    private static final Logger log = getLogger(RestaurantFormServlet.class);

    private RestaurantsRepository repository;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = InMemoryRestaurants.getInstance();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Restaurant restaurant = new Restaurant(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                LocalDateTime.parse(request.getParameter("dateTimeEditMenu")),
                Integer.parseInt(request.getParameter("countLikes")));

        log.info(restaurant.isNew() ? "Create {}" : "Update {}", restaurant);
        repository.save(restaurant);

        response.sendRedirect("restaurants");
    }

}
