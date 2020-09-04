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
    /**This servlet is responsible for triggering the logic to print the contents of a log file onto the page.  It is triggered by pressing the inspect button written
     * for each file for ViewerServlet.  The button contains the form that collects hidden inputs for each file and activates this servlet.  It takes in the file name
     * and uses the Manager class' viewFile method to collect the contents in a string, where it is this dumped onto a blank page (inspect.jsp) within <textarea> tags
     * using the forward method.  
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