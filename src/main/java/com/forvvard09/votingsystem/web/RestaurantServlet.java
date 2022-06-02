package com.forvvard09.votingsystem.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/index.html").forward(request, response);
        request.getRequestDispatcher("restaurants.jsp").forward(request, response);
        //response.sendRedirect("restaurants.jsp");
    }
}
