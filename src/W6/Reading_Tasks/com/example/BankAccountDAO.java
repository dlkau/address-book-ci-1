package W6.Reading_Tasks.com.example;

// Add necessary imports
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the data access object for the BankAccount object.
 */
public class BankAccountDAO {
    private Connection connection;

    /**
     * This constructor is used to instantiate a BankAccountDAO object
     */
    public BankAccountDAO(){
        connection = DatabaseConnection.getInstance();
    }

    public void CreateTable(){
        // ToDo Later: Create a Statement to run the CREATE TABLE query
    }

    public void insert(BankAccount bankAccount){
        // ToDo Later: Create a PreparedStatement to run the INSERT query
    }

    public void update(BankAccount bankAccount){
        // ToDo Later: Create a PreparedStatement to run the UPDATE query
    }

    public void delete(int id){
        // ToDo Later: Create a PreparedStatement to run the DELETE query
    }

    public List<BankAccount> getAll(){
        List<BankAccount> accounts = new ArrayList<>();
        // ToDO Later: Create a Statement to run the SELECT * query and populate the accoutns list above
        return accounts;
    }

    public BankAccount GetById(int id){
        // ToDo Later: Create a PreparedStatement ot urn the conditional SELECT query
        return null;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }
}