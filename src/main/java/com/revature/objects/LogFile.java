package com.revature.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//The LogFile object will be created for each time a keyword is found in a log.  Name should be equal to the log file name.
//The line array will contain the line numbers of found keywords.

public class LogFile {
    String name;
    List<Integer> line = new ArrayList<Integer>();


    public LogFile(String name) {
        this.name = name;
	}


    public void addLine(int number) {
        this.line.add(number);
    }


    public LogFile() {
    }

    public LogFile(String name, List<Integer> line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getLine() {
        return this.line;
    }

    public void setLine(List<Integer> line) {
        this.line = line;
    }

    public LogFile name(String name) {
        this.name = name;
        return this;
    }

    public LogFile line(List<Integer> line) {
        this.line = line;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LogFile)) {
            return false;
        }
        LogFile logFile = (LogFile) o;
        return Objects.equals(name, logFile.name) && Objects.equals(line, logFile.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, line);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", line='" + getLine() + "'" +
            "}";
    }




    

}