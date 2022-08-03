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
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;


public class RestaurantsServlet extends HttpServlet {
    private static final Logger log = getLogger(RestaurantsServlet.class);

    private RestaurantsRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = InMemoryRestaurants.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                log.info("Delete {}", id);
                repository.remove(id);
                response.sendRedirect("restaurants");
                break;
            case "create":
            case "update":
                final Restaurant restaurant = "create".equals(action) ?
                        new Restaurant(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)) :
                        repository.get(getId(request));
                request.setAttribute("restaurant", restaurant);
                request.getRequestDispatcher("/restaurantForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("restiks", repository.getAll());
                request.getRequestDispatcher("restaurants.jsp").forward(request, response);
                break;



        }

    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }


}
