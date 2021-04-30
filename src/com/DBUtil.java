package com;

import java.sql.*;

/**
 * Created by syx on 2021/04/28 10:21
 */
public class DBUtil {
    private static Connection connection = null;


    public static Connection getConnection() throws ClassNotFoundException {
        String Url = "jdbc:mysql://localhost:3306/library";
        String User = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(Url, User, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeResource(Connection connection, PreparedStatement pstm, ResultSet rs) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != pstm) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }
}
