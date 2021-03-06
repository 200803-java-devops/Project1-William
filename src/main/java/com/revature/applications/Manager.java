package com.revature.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.objects.LogFile;
import com.revature.objects.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//The manager's job is to take input and go retrieve the desired output from the log files.  It does a variety of functions such as
//scraping the contents of a log file, obtaining its path, and searching for log files.

public class Manager {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

     public List<LogFile> view(String path) {
        log.debug("The view method was run at " + logger.timestamp());
        List<LogFile> logs = new ArrayList<LogFile>();
        
        File[] fileList = new File(path).listFiles();

        for (File file : fileList) {
            LogFile log = new LogFile(file.getName(), file.getPath());
            logs.add(log);
            }

        return logs;
    }

    //confirm this works, create a servlet and test it out
    public String viewFile(String path, Charset encoding) throws IOException {
        log.debug("The viewFile method was run at " + logger.timestamp());
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        
        return new String(encoded, encoding);
    
    }




    public List<LogFile> search(String path, String keyword) {
        List<LogFile> logs = new ArrayList<LogFile>();
        
        File[] fileList = new File(path).listFiles();
        log.debug("The search method was run at " + logger.timestamp());


        for (File file : fileList) { 
            // handle each file - read/write etc
            //https://stackoverflow.com/questions/14374707/what-does-the-colon-mean-in-java/14374760#:~:text=It%20means%20one%20thing%2C%20it%20is%20an%20enhanced%20for%20loop.&text=When%20you%20see%20the%20colon,each%20loop%2C%20even%20for%20arrays.
        
            try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                String line = null;
                int linecounter = 0;
                Pattern p = Pattern.compile("\\b" + keyword + "\\b", Pattern.CASE_INSENSITIVE);
                LogFile log = new LogFile(file.getName(), file.getPath());
    
                while ((line = br.readLine()) != null) {
                    linecounter++;
                    //logic to find keyword
                    Matcher m = p.matcher(line);
                    //I believe m goes to null (false) when it doesn't find a match
                    while (m.find()){
                        //If it found an instance, add it to this log file's line list. 
                        log.addLine(linecounter);
                        //now that you've created that file object, keep checking for more instances
                        //Maybe create an object every time but drop it if the instance list is empty.
    
                    }
                }
                if (log.getLine().isEmpty() == true) {
                    log.setName(null);
                } else {
                    logs.add(log);
                }
                //At the end of reading through a log file and filling out its name and line occurances, add it with those attributes set to this list.
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(logger.timestamp() + e);
                }
            }

        return logs;
    }
}