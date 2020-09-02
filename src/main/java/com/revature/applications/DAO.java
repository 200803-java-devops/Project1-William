package com.revature.applications;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {
    Connection connection = null;
    PreparedStatement stmt = null;

    

    public boolean addLog(byte[] file, String comments) {
        try (connection = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO Logs (file, comments) VALUES (?,?);";

            try (stmt = connection.PrepareStatement(sql)) {
                stmt.setBytes(1, file);
                stmt.setString(2, comments);

                if (stmt.executeUpdate() != 0) {
				    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}