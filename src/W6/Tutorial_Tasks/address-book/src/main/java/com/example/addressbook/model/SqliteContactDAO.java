package com.example.addressbook.model;

// Add necessary imports
import java.security.spec.ECField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;

public class SqliteContactDAO implements IContactDAO {
    private Connection connection;

    public SqliteContactDAO() {
        connection = SqliteConnection.getInstance();
        createTable();
        // Used for testing, to be removed later
        insertSampleData();
    }

    /**
     * This method, provided the 'contacts' table does not already exist, will
     * execute the 'create table' statement in the method.
     */
    private void createTable(){
        // Create table if it does not already exist
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS contacts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "firstName VARCHAR NOT NULL,"
                    + "lastName VARCHAR NOT NULL,"
                    + "phone VARCHAR NOT NULL,"
                    + "email VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method, for the purposes of testing, inserts three records into the contacts table.
     */
    private void insertSampleData() {
        try {
            // Clear before inserting
            Statement clearStatement = connection.createStatement();
            String clearQuery = "DELETE FROM contacts";
            clearStatement.execute(clearQuery);
            Statement insertStatement = connection.createStatement();
            String insertQuery = "INSERT INTO contacts (firstName, lastName, phone, email) VALUES "
                    + "('John', 'Doe', '0423423423', 'johndoe@example.com'),"
                    + "('Jane', 'Doe', '0423423424', 'janedoe@example.com'),"
                    + "('Jay', 'Doe', '0423423425', 'jaydoe@example.com')";
            insertStatement.execute(insertQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method, given a contact, will add the contact's details to the contacts table of the database
     * @param contact the contact to be added to the database.
     */
    @Override
    public void addContact(Contact contact) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO contacts (firstName, lastName, phone, email) VALUES (?, ?, ?, ?)");
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setString(3, contact.getPhone());
            statement.setString(4, contact.getEmail());
            statement.executeUpdate();
            // Set the id of the new contact
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contact.setID(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method, given a contact, will update the corresponding contact in the database.
     * @param contact the contact to be updated.
     */
    @Override
    public void updateContact(Contact contact) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE contacts SET firstName = ?, " +
                    "lastName = ?, phone = ?, email = ? WHERE id = ?");
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setString(3, contact.getPhone());
            statement.setString(4, contact.getEmail());
            statement.setInt(5, contact.getId());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method, given a contact, will delete it from the contacts table in the database.
     * @param contact the contact to be removed from the database.
     */
    @Override
    public void deleteContact(Contact contact) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM contacts WHERE id = ?");
            statement.setInt(1, contact.getId());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method, given an id, will look at the database and retrieve the id from the database.
     * @param id the id of the contact to be retrieved from the database.
     * @return the contact with the provided id.
     */
    @Override
    public Contact getContact(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contacts WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Contact contact = new Contact(firstName, lastName, phone, email);
                contact.setID(id);
                return contact;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method returns all the contacts in the database.
     * @return a list of contacts in the database
     */
    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM contacts";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName =  resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Contact contact = new Contact(firstName, lastName, phone, email);
                contact.setID(id);
                contacts.add(contact);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return contacts;
    }
}
