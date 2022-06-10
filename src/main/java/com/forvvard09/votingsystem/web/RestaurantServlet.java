package com.forvvard09.votingsystem.web;





import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


public class RestaurantServlet extends HttpServlet {
    private static final Logger log = getLogger(RestaurantServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Тестирование логирования. Пришли в сервлет. Редирект на список ресторанов");
        log.info("Redirect to restaurants.jsp");
        //request.getRequestDispatcher("restaurants.jsp").forward(request, response);
        response.sendRedirect("restaurants.jsp");
    }
}
