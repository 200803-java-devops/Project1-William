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
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogFile> logs = new ArrayList<LogFile>();
        Manager manager = new Manager();
        String path = req.getParameter("filePath");
        logs = manager.view(path);
        

        req.setAttribute("list", list(logs));
        req.setAttribute("path", path);

        req.getRequestDispatcher("view.jsp").forward(req, resp);

    }
    private String list(List<LogFile> logs) {
        String string = "";
        if (logs.isEmpty()) {
            string = "<p>No files were found in that path.</p>";
        } else {
            for(int i = 0; i < logs.size(); i++) {
                string += "<div>" + logs.get(i).getName() + "<form style=\"display:inline-block;\" action=\"/Project1/inspect\" method=\"GET\"><input type=\"hidden\" name=\"file\" id=\"file\" value=\"" + logs.get(i).getPath() + "\"/> <input type = \"submit\" id=\"button\" value = \"inspect\"/> </form><div>";
        }
        }
        return string;
    }


}