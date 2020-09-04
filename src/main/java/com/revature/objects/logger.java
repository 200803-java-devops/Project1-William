package com.revature.objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This class contains code that will be used by the logger.  There may be a method for the logger to do this stuff already, but I can't find anythnig like it.  This was
//just easier and quicker.
public class logger {

    public static String timestamp () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String timestamp = dtf.format(now);
        return timestamp;
    }



}
