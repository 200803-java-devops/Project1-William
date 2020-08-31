package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.applications.IOHandler;
import com.revature.applications.Manager;
import com.revature.objects.LogFile;

public class SearcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogFile> logs = new ArrayList<LogFile>();
        //IOHandler io = new IOHandler();  NO NEED FOR AN IOHANDLER OBJ ANYMORE AS THE SERVLET DOES THAT.
        String path = req.getParameter("filePath");
        String keyword = req.getParameter("keyword");
       
        Manager manager = new Manager();
        logs = manager.search(path, keyword);

        
        //How can I move his function to another class (and should I) when I need the response object?
        if (logs.isEmpty()) {
            resp.getWriter().println("No instances of the keyword were found for that path.");
        } else {
            resp.getWriter().println("Instances found:");
            for(int i = 0; i < logs.size(); i++) {
                resp.getWriter().println("- File: " + logs.get(i).getName() + " at lines: " + logs.get(i).getLine());
        }
        }
        //resp.getWriter().println("</br> <a ")
    }
}