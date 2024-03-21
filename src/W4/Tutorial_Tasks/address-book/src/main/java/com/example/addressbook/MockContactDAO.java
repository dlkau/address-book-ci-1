package com.example.addressbook;

import java.util.ArrayList;
import java.util.List;

public class MockContactDAO implements IContactDAO{
    public static final ArrayList<Contact> contacts = new ArrayList<>();
    private static int autoIncrementID = 0;

    /**
     * This constructor instantiates a MockContactDAO object, adding three mock contacts to the 'database.'
     */
    public MockContactDAO(){
        // Add some initial contacts to the Mock database
        addContact(new Contact("John", "Doe", "JohnDoe@example.com", "0412122123"));
        addContact(new Contact("Mary", "Doe", "MaryDoe@example.com", "0412174826"));
        addContact(new Contact("Bob", "Doe", "BobDoe@example.com", "0430962842"));
    }

    /**
     * This method adds a new contact to the database.
     * @param contact the contact to be added to the database.
     */
    @Override
    public void addContact(Contact contact){
        contact.setID(autoIncrementID);
        autoIncrementID++;
        contacts.add(contact);
    }

    /**
     * This method, given a contact, will iterate over the current contact list, find this contact
     * and update the contact's details.
     * @param contact the contact to be updated.
     */
    @Override
    public void updateContact(Contact contact){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getId() == contact.getId()){
                // Replace the old contact with the new one.
                contacts.set(i, contact);
                break;
            }
        }
    }

    /**
     * This method removes a given contact from the static contacts list.
     * @param contact the contact to be removed from the database.
     */
    @Override
    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }

    /**
     * This method returns a contact with the provided id. If the id cannot be found,
     * the method returns null/
     * @param id the id of the contact to be retrieved from the database.
     * @return a contact or null if the contact could not be found.
     */
    @Override
    public Contact getContact(int id){
        for (Contact contact : contacts){
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }

    /**
     * This method returns a list of all the contacts currently in the mock database.
     * @return a list of contacts from the mock database.
     */
    @Override
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contacts);
    }
}
