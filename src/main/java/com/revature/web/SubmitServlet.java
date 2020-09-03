package com.revature.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.applications.DAO;

public class SubmitServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String comment = req.getParameter("comments");
        String name = req.getParameter("name");

        //literally just getting the wrong path right now
        String path = req.getParameter("file");


        //This turns the file into bytes that I think I can then upload.  Play around and test.
        byte[] rawfile = Files.readAllBytes(Paths.get(path));

        //they do something like this in pubhub to account for the "part" thing.  Honestly maybe 
        //ignore this and comment it out just for now.

        /*
        Part content = rawfile;

        InputStream is = null;
        ByteArrayOutputStream os = null;

        try {
            is = content.getInputStream();
            os = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];

            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
            
            book.setContent(os.toByteArray());

        } catch (IOException e) {
            System.out.println("Could not upload file!");
            e.printStackTrace();
        } finally {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
        }
        */

        DAO dao = new DAO();
        if(dao.addLog(rawfile,name,comment) == true) {
            // We use a redirect here instead of a forward, because we don't
            // want request data to be saved. Otherwise, when
            // a user clicks "refresh", their browser would send the data 
            // again!
            // This would be bad data management, and it
            // could result in duplicate rows in a database.
            req.setAttribute("list", "Log successfully submitted");
        }else {
            req.setAttribute("list", "Log did not submit properly.  Please contact developer.");
            
        }
        resp.sendRedirect(req.getContextPath() + "/search.jsp");
    }
}