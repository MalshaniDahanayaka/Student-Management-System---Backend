package com.kelaniya.backend.utils.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataRetriever {
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/lms";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";
    private Connection conn;

    public DataRetriever(){
        setDatabaseConnection();
    }



    public void setDatabaseConnection() {
        try {
            Class.forName(this.DB_DRIVER);
            conn = DriverManager.getConnection(this.DB_URL, this.DB_USERNAME, this.DB_PASSWORD);


        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("db connection error");
        }

    }



    public Connection getDatabaseConnection() {

        return conn;
    }




}