package jm.task.core.jdbc.util;

import org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;

import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata_pp_1_1_3-4_jdbc_hibernate";
    private static final String user = "root";
    private static final String password = "root";
    public static Connection getConnection() {
        Connection connection;
        Driver driver;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
