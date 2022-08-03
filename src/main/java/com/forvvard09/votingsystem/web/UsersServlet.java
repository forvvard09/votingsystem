package com.forvvard09.votingsystem.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UsersServlet extends HttpServlet {

    private static final Logger log = getLogger(UsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User servlet. Redirect/forward to users.jsp");
        // to do проверить как работает редирект и форвард
        //req.getRequestDispatcher("/users.jsp").forward(req, resp);
        resp.sendRedirect("users.jsp");
    }
}
