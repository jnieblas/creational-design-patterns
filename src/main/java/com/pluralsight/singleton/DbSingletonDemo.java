package main.java.com.pluralsight.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String[] args) {
        DbSingleton instance = DbSingleton.getInstance();

        long before = 0;
        long after = 0;

        // First connection will take longer than the second
        // Connection is created in this first getConnection
        before = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        after = System.currentTimeMillis();

        System.out.println(after - before);

        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
            System.out.println("Table created.");
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Optimized, takes 0 seconds to receive the connection
        // This is because the connection instance was already created
        before = System.currentTimeMillis();
        conn = instance.getConnection();
        after = System.currentTimeMillis();

        System.out.println(after - before);
    }
}
