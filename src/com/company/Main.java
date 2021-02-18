package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/test";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "postgres");

            // The object of statement is responsible to execute queries with the database
            stmt = con.createStatement();

            // The executeQuery() method of Statement interface is used to execute queries
            // to the database. This method returns the object of ResultSet that can be
            // used to get all the records of a table that matches the sql statement
            rs = stmt.executeQuery("select * from users");

            while (rs.next()) // Processing the result
                System.out.println(rs.getInt("id") + "  "
                        + rs.getString("name") + "  " + rs.getString("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try { // Close connection - clean up the system resources
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        MyApplication app = new MyApplication(repo);
        app.start();
    }
}