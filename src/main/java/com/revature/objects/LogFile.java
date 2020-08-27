package com.revature.objects;

import java.util.List;

//The LogFile object will be created for each time a keyword is found in a log.  Name should be equal to the log file name.
//The line array will contain the line numbers of found keywords.

public class LogFile {
    String name;
    List<Integer> line;


    public LogFile(String name) {
        this.name = name;
        this.line = null;
	}


    public void addLine(int number) {
        this.line.add(number);
    }

    

}