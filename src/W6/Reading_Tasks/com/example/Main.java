package W6.Reading_Tasks.com.example;

// Add necessary imports
import W6.Reading_Tasks.com.example.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        // Instantiate the connection to the database
        Connection connection = DatabaseConnection.getInstance();
    }
}
