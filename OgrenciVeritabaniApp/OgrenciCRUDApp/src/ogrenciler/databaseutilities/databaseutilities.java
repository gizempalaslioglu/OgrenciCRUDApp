package ogrenciler.databaseutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseutilities {

    public static String url = "jdbc:mysql://localhost:3306/ogrenciler?useTimezone=true&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "ianninasobrev";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

}
