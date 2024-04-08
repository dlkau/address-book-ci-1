package W6.Reading_Tasks.com.example;

// Add necessary imports
import W6.Reading_Tasks.com.example.DatabaseConnection;
import java.util.List;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        // Instantiate the connection to the database
        Connection connection = DatabaseConnection.getInstance();
        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        bankAccountDAO.CreateTable();

        // Insert some new records
        // bankAccountDAO.insert(new BankAccount("John", "Doe", 10000));
        // bankAccountDAO.insert(new BankAccount("Jane", "Doe", 20000));
        // bankAccountDAO.insert(new BankAccount("Alice", "Smith", 30000));

        // Retrieve all the records from the bankAccount details
        List<BankAccount> accounts = bankAccountDAO.getAll();
        for (BankAccount acc : accounts){
            System.out.println(acc);
        }


        bankAccountDAO.close();
    }
}