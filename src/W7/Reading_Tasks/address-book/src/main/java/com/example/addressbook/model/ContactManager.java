package com.example.addressbook.model;

// Add necessary class imports
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private IContactDAO contactDAO;
    public ContactManager(IContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> searchContacts(String query) {
        if (query == null || query.isEmpty()) {
            return contactDAO.getAllContacts();
        }
        ArrayList<Contact> results = new ArrayList<>();
        for (Contact contact : contactDAO.getAllContacts()) {
            if (contact.getFullName().contains(query)) {
                results.add(contact);
            }
        }
        return results;
    }

    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }


}
