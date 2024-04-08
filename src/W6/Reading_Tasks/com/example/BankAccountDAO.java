package W6.Reading_Tasks.com.example;

// Add necessary imports
import javax.swing.plaf.nimbus.State;
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

    /**
     * This method, given a bankAccount object, will update the corresponding value in the database.
     * @param bankAccount the bank account to be updated.
     */
    public void update(BankAccount bankAccount){
        try{
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE bankAccounts SET firstName = ?, lastName = ?, bankBalance = ? WHERE id = ?"
            );
            updateAccount.setString(1, bankAccount.getFirstName());
            updateAccount.setString(2, bankAccount.getLastName());
            updateAccount.setInt(3, bankAccount.getBankBalance());
            updateAccount.setInt(4, bankAccount.getId());
            updateAccount.execute();
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }

    /**
     * This method, given a bank account id, will delete a given bank account record.
     * @param id the id of the BankAccount record to be deleted.
     */
    public void delete(int id){
        try {
            PreparedStatement deleteAccount = connection.prepareStatement("DELETE FROM bankAccounts WHERE id = ?");
            deleteAccount.setInt(1, id);
            deleteAccount.execute();
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }

    /**
     * This method is used to return a list of BankAccounts from the database.
     * @return a list of the bankAccount objects based on the records from the bankAccounts table
     */
    public List<BankAccount> getAll(){
        List<BankAccount> accounts = new ArrayList<>();
        try {
            Statement getAll = connection.createStatement();
            ResultSet rs = getAll.executeQuery("SELECT * FROM bankAccounts");
            while(rs.next()){
                accounts.add(
                        new BankAccount(
                                rs.getInt("id"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getInt("bankBalance")
                        )
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return accounts;
    }

    /**
     * This method, given a certain id, will return a BankAccount object attached to it.
     * @param id the id of the bankAccount to be retrieved.
     * @return a BankAccount object for the given id.
     */
    public BankAccount GetById(int id){
        try{
            PreparedStatement getAccount = connection.prepareStatement("SELECT * FROM bankAccounts WHERE id = ?");
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();
            if(rs.next()){
                return new BankAccount(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("bankBalance")
                );
            }
        } catch (SQLException ex){
            System.err.println(ex);
        }
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