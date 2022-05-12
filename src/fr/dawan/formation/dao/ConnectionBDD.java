package fr.dawan.formation.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBDD
{
    private static Connection cnx;

    static
    {
        try{
            Properties p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf.properties"));
            Class.forName(p.getProperty("driver"));
            cnx = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionBDD()
    {

    }

    public static Connection getConnection()
    {
        return cnx;
    }
}
