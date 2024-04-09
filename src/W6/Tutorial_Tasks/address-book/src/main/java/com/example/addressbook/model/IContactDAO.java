package com.example.addressbook.model;

import com.example.addressbook.model.Contact;

import java.util.List;

/**
 * This interface will be used for the Contact Data Access Object that handles the CRUD operations
 * for the Contact class with the database.
 */
public interface IContactDAO {

    /**
     * This method will add a new contact to the database.
     * @param contact the contact to be added to the database.
     */
    public void addContact(Contact contact);

    /**
     * This method will be used to update an existing contact in the database.
     * @param contact the contact to be updated.
     */
    public void updateContact(Contact contact);

    /**
     * This is the contact which needs to be deleted from the database.
     * @param contact the contact to be removed from the database.
     */
    public void deleteContact(Contact contact);

    /**
     * This method will retrieve a contact based on the id provided.
     * @param id the id of the contact to be retrieved from the database.
     * @return the contact who has the id provided in the method.
     */
    public Contact getContact(int id);

    /**
     * This method returns all the contacts from the database.
     * @return a list of contacts from the database.
     */
    public List<Contact> getAllContacts();
}