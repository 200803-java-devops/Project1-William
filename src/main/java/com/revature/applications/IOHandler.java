package com.revature.applications;

public class IOHandler {
    
   public String getPath() {
       //System.out.println("Please type the path to your project's root folder");
       //take in input to get the folder path dynamically
        
       String path = "C:\\Users\\a\\Desktop\\Revature\\bootcamp projects\\Project0";
       path = path.replace("\\", "/");
       return path;
   }
}