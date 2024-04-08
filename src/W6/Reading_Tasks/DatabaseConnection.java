package W6.Reading_Tasks;

// Add necessary java imports
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Define a singleton class for a database connection.
 */
public class DatabaseConnection {
    /**
     * The singleton instance of the database connection.
     */
    private static Connection instance = null;

    private DatabaseConnection(){
        String url = "jdbc:sqlite:database.db";
        try {
            instance = DriverManager.getConnection(url);
        } catch (SQLException sqlEx) {
            System.err.println(sqlEx);
        } 
    }

    public static Connection getInstance() {
        if (instance == null) {
            new DatabaseConnection();
        }
        return instance;
    }
}