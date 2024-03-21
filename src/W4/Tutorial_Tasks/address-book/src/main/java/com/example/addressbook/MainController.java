package com.example.addressbook;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {
    @FXML
    private ListView<Contact> contactsListView;
    private IContactDAO contactDAO;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;

    public MainController(){
        contactDAO = new MockContactDAO();
        contactDAO.addContact(new Contact("Jerry", "Doe", "jerrydoe@example.com",
                "0423423426"));
    }

    /**
     * This method selects the contact in the list view and updates the text fields
     * with the contact's information.
     * @param contact the contact which was selected.
     */
    private void selectContact(Contact contact){
        contactsListView.getSelectionModel().select(contact);
        firstNameTextField.setText(contact.getFirstName());
        lastNameTextField.setText(contact.getLastName());
        emailTextField.setText(contact.getEmail());
        phoneTextField.setText(contact.getPhone());
    }

    /**
     * This method renders a cell in the contacts list view by setting the text to
     * the contact's full name.
     * @param contactListView this is the list view to render the cell for.
     * @return the rendered cell.
     */
    private ListCell<Contact> renderCell(ListView<Contact> contactListView){
        return new ListCell<>(){
            private void onContactSelected(MouseEvent mouseEvent){
                ListCell<Contact> clickedCell = (ListCell<Contact>) mouseEvent.getSource();
                // Get the selected contact from the list view
                Contact selectedContact = clickedCell.getItem();
                if (selectedContact != null) selectContact(selectedContact);
            }

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
                    super.setOnMouseClicked(this::onContactSelected);
                } else {
                    setText(contact.getFullName());
                }
            }
        };
    }

    /**
     * This method synchronizes the contacts list view with the contacts in the database.
     */
    private void syncContacts(){
        contactsListView.getItems().clear();
        contactsListView.getItems().addAll(contactDAO.getAllContacts());
    }

    /**
     * This method updates the given contact with the information provided in each of the
     * text boxes.
     */
    @FXML
    private void onEditConfirm(){
        // Get the selected contact from the list view
        Contact selectedContact = contactsListView.getSelectionModel().getSelectedItem();
        if(selectedContact != null){
            selectedContact.setFirstname(firstNameTextField.getText());
            selectedContact.setLastName(lastNameTextField.getText());
            selectedContact.setEmail(emailTextField.getText());
            selectedContact.setPhone(phoneTextField.getText());
            contactDAO.updateContact(selectedContact);
            syncContacts();
        }
    }

    @FXML
    public void initialize(){
        contactsListView.setCellFactory(this::renderCell);
        contactsListView.getItems().addAll(contactDAO.getAllContacts());
    }
}