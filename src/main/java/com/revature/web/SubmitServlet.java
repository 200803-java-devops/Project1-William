package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get the filename and the comments (which should require some JS)
        //Then just submit...Maybe have some JS to remove submit button
        //Can I prevent page from refreshing or changing?

        //JS sets the "comment" id = to the user input value.
        //This is assuming JS won't be confused which one it's looking at, TEST
        String comment = req.getParameter("comment");

        //This one will be more complicated.  Get either the path or just the filename to start.
        String path = req.getParameter("file");

        resp.getWriter().println(file + "---" + comment);
        //Go ahead and declare and map out the servlet so that issue gets ruled out.
        byte[] file = Files.readAllBytes(Paths.get(path));
        //from here, get the file and send it to DAO.addLog along with comment

    }
}