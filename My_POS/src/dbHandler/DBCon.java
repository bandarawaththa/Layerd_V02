package dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    private static DBCon dbCon;
    private Connection connection;

    private DBCon() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "");

    }

    public static DBCon getInstance() throws SQLException, ClassNotFoundException {
        return ((null == dbCon) ? (dbCon = new DBCon()) : dbCon);
    }

    public Connection getConnection() {
        return connection;
    }
}