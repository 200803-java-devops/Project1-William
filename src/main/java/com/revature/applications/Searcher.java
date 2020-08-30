package com.revature.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.objects.LogFile;

public class Searcher {

     //case will be ignored

    public List<LogFile> search(String path, String keyword) {
        List<LogFile> logs = new ArrayList<LogFile>();
        
        File[] fileList = new File(path).listFiles();


        for (File file : fileList) { 
            // handle each file - read/write etc
            //https://stackoverflow.com/questions/14374707/what-does-the-colon-mean-in-java/14374760#:~:text=It%20means%20one%20thing%2C%20it%20is%20an%20enhanced%20for%20loop.&text=When%20you%20see%20the%20colon,each%20loop%2C%20even%20for%20arrays.
        
            //now need to use filereader to read each one.  Will need some kind of variables set to catch keywords
            try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                String line = null;
                int linecounter = 0;
                Pattern p = Pattern.compile("\\b" + keyword + "\\b", Pattern.CASE_INSENSITIVE);
                LogFile log = new LogFile(file.getName());
    
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
                }
            }

        return logs;
    }
}