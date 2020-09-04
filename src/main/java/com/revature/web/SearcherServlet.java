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

public class SearcherServlet extends HttpServlet {
    /** This servlet is responsible for triggering the logic required to perform the keyword search, return the results, and create a button for submitting each found file
     * to the db.  It uses the file path and keyword provided by the user (which are forced via JS to not be blank).  
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<LogFile> logs = new ArrayList<LogFile>();
        String path = req.getParameter("filePath");
        String keyword = req.getParameter("keyword");
       
        Manager manager = new Manager();
        logs = manager.search(path, keyword);


        req.setAttribute("list", list(logs));



       
        req.getRequestDispatcher("search.jsp").forward(req, resp);
        //resp.getWriter().println("</br> <a ")


        /*
        if (logs.isEmpty()) {
            resp.getWriter().println("No instances of the keyword were found for that path.  Please double check your path provided.");
        } else {
            resp.getWriter().println("Instances found:");
            for(int i = 0; i < logs.size(); i++) {
                resp.getWriter().println("- File: " + logs.get(i).getName() + " at lines: " + logs.get(i).getLine());
        }
        */
    }
    private String list(List<LogFile> logs) {
        String string = "";
        if (logs.isEmpty()) {
           string = "No instances of the keyword were found for that path.  Please double check your path provided.";
        } else {
            string += "<p>Your results:</p>";
            for(int i = 0; i < logs.size(); i++) {
                string += "<div>-File: " + "<span>" + logs.get(i).getName() + "</span> at lines: " + logs.get(i).getLine() + " " + "<form style=\"display:inline-block;\" action=\"/Project1/submit\" method=\"POST\"><input type=\"hidden\" name=\"comments\" id=\"comments\" value=\"\" /> <input type=\"hidden\" name=\"file\" id=\"file\" value=\"" + logs.get(i).getPath() + "\"/> <input type=\"hidden\" name=\"name\" id=\"name\" value=\"" + logs.get(i).getName() + "\"/> <input type = \"submit\" id=\"button\" value = \"Report to Developers\" onClick=\"return empty3()\" /> </form></div>";
        }
        }
        return string;
    }

}