package com.revature.applications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.objects.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//It is this class' job to query the database and return desired data.

public class DAO {
    Connection connection = null;
    PreparedStatement stmt = null;


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    

    public boolean addLog(byte[] file, String name, String comments) {
        log.debug("The database is being queried at " + logger.timestamp());
        try {
            connection = DBconnect.getConnection();
            String sql = "INSERT INTO logs (file, filename, comment) VALUES (?,?,?);";
            stmt = connection.prepareStatement(sql);
            stmt.setBytes(1, file);
            stmt.setString(2, name);
            stmt.setString(3,comments);

            

            if (stmt.executeUpdate() != 0) {
                System.out.println("Query was successful");
			    return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
            connection.close();
            stmt.close();
            } catch (SQLException r) {
                r.printStackTrace();
                return false;
            }
            return false;
        }
    }
}