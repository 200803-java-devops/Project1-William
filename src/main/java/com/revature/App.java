package com.revature;

import java.io.File;
import java.util.Optional;

import com.revature.web.InspectServlet;
import com.revature.web.SearcherServlet;
import com.revature.web.SubmitServlet;
import com.revature.web.ViewerServlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    
    public static void main(String[] args) throws LifecycleException {
        String contextPath = "/Project1";
        String appBase = new File("src/main/resources").getAbsolutePath();
        Tomcat server = new Tomcat();
        server.setBaseDir(new File("target/tomcat/").getAbsolutePath());
        server.setPort(Integer.valueOf(port.orElse("8080")));
        server.getConnector(); //connects tomcat to an HTTP service, runs tomcat on HTTP mode
        server.addWebapp(contextPath, appBase);
        server.addServlet(contextPath, "SearcherServlet", new SearcherServlet()).addMapping("/search");
        server.addServlet(contextPath, "ViewerServlet", new ViewerServlet()).addMapping("/view");
        server.addServlet(contextPath, "SubmitServlet", new SubmitServlet()).addMapping("/submit");
        server.addServlet(contextPath, "InspectServlet", new InspectServlet()).addMapping("/inspect");
        server.start();
        server.getServer().await();
    }
}