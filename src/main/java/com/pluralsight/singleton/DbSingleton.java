package main.java.com.pluralsight.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    // The image that we will be distributing - allows for us to control distribution
    // volatile ensures that other threads don't use instance until it is done being created
    private static volatile DbSingleton instance = null;
    private static volatile Connection conn = null;

    // Another way that Singleton controls distribution - prevents outside entities from instantiating DbSingleton objects
    private DbSingleton() {

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(conn != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }

        // Prevents a reflection class from creating an instance of this DbSingleton
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    // Standard naming convention, doesn't have to be called this
    // Necessity in Singleton - will return private instance
    // Synchronized not used on method / class because it will be a performance hit
    public static DbSingleton getInstance() {
        if(instance == null)
            // Synchronized double check allows for JVM to check other threads to make sure that they haven't already created this object
            // The 'volatile' instance can be checked via 'synchronized', since it has been marked as not being thread safe
            // Good idea to synchronize before creating this instance, as we need to know if any other class has already done this
            synchronized (DbSingleton.class) {
                if(instance == null)
                    instance = new DbSingleton();
            }

        return instance;
    }

    // Intentionally not static - we want an instance of the DbSingleton to use when calling this method, since this isn't the DbSingleton instance.
    // Otherwise, the DbSingleton class would be statically calling its internal variables, when it should be doing so dynamically as an object
    public Connection getConnection() {
        if(conn == null)
            synchronized (DbSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        return conn;
    }
}
