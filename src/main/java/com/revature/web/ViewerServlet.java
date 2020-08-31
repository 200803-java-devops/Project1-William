package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.applications.Manager;
import com.revature.objects.LogFile;

public class ViewerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogFile> logs = new ArrayList<LogFile>();
        Manager manager = new Manager();
        String path = req.getParameter("filePath"); //this is gonna have to be reviewed, the whole UI bit
        logs = manager.view(path);

        if (logs.isEmpty()) {
            resp.getWriter().println("No log files found for that path.");
        } else {
            resp.getWriter().println("Files found:");
            for(int i = 0; i < logs.size(); i++) {
                resp.getWriter().println(logs.get(i).getName());
        }
        }

    }

}