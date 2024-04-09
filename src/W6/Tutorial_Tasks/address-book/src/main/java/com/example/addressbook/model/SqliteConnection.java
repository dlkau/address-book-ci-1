package com.example.addressbook.model;

// Add necessary imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This singleton class will handle the sql connection.
 */
public class SqliteConnection {
    private static Connection instance = null;

    /**
     * This private constructor is used to instantiate an instance of the connection with the database.
     */
    private SqliteConnection() {
        String url = "jdbc:sqlite:contacts.db";
        try{
            instance = DriverManager.getConnection(url);
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }

    /**
     * This method, when invoked, will either call the private SqliteConnection constructor to instantiate a
     * connection instance (if instance is null), or it will return the current instance.
     * @return a connection instance to the database.
     */
    public static Connection getInstance(){
        if(instance == null){
            new SqliteConnection();
        }
        return instance;
    }


}
