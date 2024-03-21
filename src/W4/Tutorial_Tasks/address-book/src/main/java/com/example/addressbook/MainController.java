package com.example.addressbook;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class MainController {
    @FXML
    private ListView<Contact> contactsListView;
    private IContactDAO contactDAO;
    public MainController(){
        contactDAO = new MockContactDAO();
    }

    private ListCell<Contact> renderCell(ListView<Contact> contactListView){
        return new ListCell<>(){
            /**
             * Updates the item in the cell by setting the text to the contact's full name.
             * @param contact the contact to update the cell with
             * @param empty a Boolean denoting whether a cell is empty or not.
             */
            @Override
            protected void updateItem(Contact contact, boolean empty){
                super.updateItem(contact, empty);
                // If the cell is empty, set the text to null, otherwise set it to the contacts full name
                if (empty || contact == null || contact.getFullName() == null){
                    setText(null);
                } else {
                    setText(contact.getFullName());
                }
            }
        };
    }
    @FXML
    public void initialize(){
        contactsListView.setCellFactory(this::renderCell);
        contactsListView.getItems().addAll(contactDAO.getAllContacts());
    }
}