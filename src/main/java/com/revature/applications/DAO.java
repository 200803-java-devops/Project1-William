package com.revature.applications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.applications.DBconnect;

public class DAO {
    Connection connection = null;
    PreparedStatement stmt = null;
    

    

    public boolean addLog(byte[] file, String name, String comments) {
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