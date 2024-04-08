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

    /**
     * This method is used to create a BankAccount table.
     */
    public void CreateTable(){
        try {
            Statement createTable = connection.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS bankAccounts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "firstName VARCHAR NOT NULL, "
                    + "lastName VARCHAR NOT NULL, "
                    + "bankBalance INTEGER NOT NULL"
                    + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * This method is used to insert a new BankAccount record into the bankAccounts table.
     * @param bankAccount the bank account to be inserted.
     */
    public void insert(BankAccount bankAccount){
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO bankAccounts (firstName, lastName, bankBalance) values (?, ?, ?)"
            );
            insertAccount.setString(1, bankAccount.getFirstName());
            insertAccount.setString(2, bankAccount.getLastName());
            insertAccount.setInt(3, bankAccount.getBankBalance());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
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