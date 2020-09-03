package com.revature.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.applications.Manager;

public class InspectServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String path = req.getParameter("file");
       
        Manager manager = new Manager();
        String contents = manager.viewFile(path, StandardCharsets.UTF_8);

        req.setAttribute("string", contents);

        RequestDispatcher rd = req.getRequestDispatcher("inspect.jsp");
        rd.forward(req, resp);

    }

}