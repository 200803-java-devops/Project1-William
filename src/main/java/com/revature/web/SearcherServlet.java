package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.applications.IOHandler;
import com.revature.applications.Searcher;
import com.revature.objects.LogFile;

public class SearcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogFile> logs = new ArrayList<LogFile>();
        IOHandler io = new IOHandler();
        String path = io.getPath();
        
        Searcher searcher = new Searcher();
        logs = searcher.search(path);
        //an io method to unpackage and deliver as readable output
        //can even just debug and see if things are holding value properly
        resp.getWriter().println("Instances found:");
        for(int i = 0; i < logs.size(); i++) {
            resp.getWriter().println("File: " + logs.get(i).getName() + " at lines: " + logs.get(i).getLine());
        }
    }
}