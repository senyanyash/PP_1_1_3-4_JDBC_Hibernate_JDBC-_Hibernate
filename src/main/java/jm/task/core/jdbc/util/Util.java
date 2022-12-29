package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata_pp_1_1_3-4_jdbc_hibernate?useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
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
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.URL, url);
        properties.put(Environment.USER, user);
        properties.put(Environment.PASS, password);
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "none");
        return new Configuration().addAnnotatedClass(User.class).addProperties(properties).buildSessionFactory();
    }


}
