package com.revature.applications;

public class IOHandler {
    
   public String getInputs(String input1, String input2) {
       //System.out.println("Please type the path to your project's root folder");
       //take in input to get the folder path dynamically
        
       String path = input1;
       //"C:\\Users\\a\\Desktop\\Revature\\bootcamp projects\\Project0\\Logs";
       path = path.replace("\\", "/");


       return path;
   }

   
}