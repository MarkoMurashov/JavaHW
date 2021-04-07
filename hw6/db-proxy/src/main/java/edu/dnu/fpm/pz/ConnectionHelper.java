package edu.dnu.fpm.pz;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHelper {

    public static Connection getConnection(){

        Properties props = new Properties();
        try (InputStream in =
                     ConnectionHelper.class.getClassLoader().getResourceAsStream("db/db.properties")) {
            props.load(in);
        }
        catch (IOException e){
            System.out.println("Not found");
        }

        String drivers = props.getProperty("driver");
        if (drivers != null) {
            System.setProperty("driver", drivers);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        Connection conn = null;
        try{
          conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            System.out.println("Could not connect to db !");
            e.printStackTrace();
        }
        return conn;
    }
}

