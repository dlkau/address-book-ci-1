package com.example.addressbook.model;

// Add necessary imports
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;

public class SqliteContactDao implements IContactDAO {
    private Connection connection;

    public SqliteContactDao(){
        connection = SqliteConnection.getInstance();
        createTable();
    }

    /**
     * This method, provided the 'contacts' table does not already exist, will
     * execute the 'create table' statement in the method.
     */
    public void createTable(){
        // Create table if it does not already exist
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS contacts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "firstName VARCHAR NOT NULL,"
                    + "lastName VARCHAR NOT NULL,"
                    + "phone VARCHAR NOT NULL,"
                    + "email VARCHAR NOT NULL,"
                    + ")";
            statement.execute(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public Contact getContact(int id) {
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return null;
    }
}
