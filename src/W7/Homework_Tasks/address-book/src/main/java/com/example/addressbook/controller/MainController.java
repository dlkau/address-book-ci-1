package com.example.addressbook.controller;

import com.example.addressbook.model.Contact;
import com.example.addressbook.model.ContactManager;
import com.example.addressbook.model.IContactDAO;
import com.example.addressbook.model.SqliteContactDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.regex.Pattern;

public class MainController {
    @FXML
    private ListView<Contact> contactsListView;
    private ContactManager contactManager;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private VBox contactContainer;
    @FXML
    private Label res;
    @FXML
    TextField searchFirstNameTextField;
    @FXML
    TextField searchLastNameTextField;
    @FXML
    private TextField searchTextField;

    public MainController(){
        contactManager = new ContactManager(new SqliteContactDAO());
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
    private void syncContacts() {
        contactsListView.getItems().clear();
        // --- New code to search for contacts ---
        String query = searchTextField.getText();
        List<Contact> contacts = contactManager.searchContacts(query);
        // --- End of new code ---
        boolean hasContact = !contacts.isEmpty();
        if (hasContact) {
            contactsListView.getItems().addAll(contacts);
        }
        // Show / hide based on whether there are contacts
        contactContainer.setVisible(hasContact);
    }

    /**
     * This method updates the given contact with the information provided in each of the
     * text boxes.
     */
    @FXML
    private void onEditConfirm(){
        // Get the selected contact from the list view
        Contact selectedContact = contactsListView.getSelectionModel().getSelectedItem();




        emailTextField.setStyle(null);
        if(selectedContact != null){


            // Check the email
            String pattern = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
            boolean isValidEmail = Pattern.compile(pattern).matcher(emailTextField.getText()).matches();
            if (!isValidEmail){
                emailTextField.setStyle("-fx-border-color: red;");
                return;
            }
            // Ensure red styling is removed if email address is valid
            emailTextField.setStyle(null);
            selectedContact.setEmail(emailTextField.getText());
            selectedContact.setFirstname(firstNameTextField.getText());
            selectedContact.setLastName(lastNameTextField.getText());
            selectedContact.setPhone(phoneTextField.getText());
            contactManager.updateContact(selectedContact);
            syncContacts();
        }
    }

    /**
     * This method is used to delete a contact from the database.
     */
    @FXML
    private void onDelete(){
        // Get the selected contact from the list view
        Contact selectedContact = contactsListView.getSelectionModel().getSelectedItem();
        if (selectedContact != null){
            contactManager.deleteContact(selectedContact);
            syncContacts();
        }
    }

    /**
     * This method adds a contact to the database.
     */
    @FXML
    private void onAdd(){
        // Default values for a new contact
        final String DEFAULT_FIRST_NAME = "New";
        final String DEFAULT_LAST_NAME = "Contact";
        final String DEFAULT_EMAIL = "";
        final String DEFAULT_PHONE = "";
        Contact newContact = new Contact(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
        // Add the new contact to the database
        contactManager.addContact(newContact);
        syncContacts();
        // Select the new contact in the list view
        // and focus the first name text field
        selectContact(newContact);
        firstNameTextField.requestFocus();
    }

    /**
     * This method is used to handle cases where the user selects the cancel button.
     */
    @FXML
    private void onCancel(){
        // Find the selected contact
        Contact selectedContact = contactsListView.getSelectionModel().getSelectedItem();
        if (selectedContact != null){
            // Since the contact has not been modified, we can just re-select it ot refresh the text fields
            selectContact(selectedContact);
        }
    }

    /**
     * This search method, when invoked, will retrieve all the details about a contact based on their first and last
     * name.
     */
    @FXML
    private void search(){
        List<Contact> contacts = contactManager.getAllContacts();
        for (Contact contact : contacts ) {
            if (contact.getFirstName().equals(searchFirstNameTextField.getText()) &&
                    contact.getLastName().equals(searchLastNameTextField.getText())) {
                String contactDetails = "Name: " + contact.getFirstName() + " " + contact.getLastName() +
                        "\n" + "Phone Number: " + contact.getPhone() + "\n" + "Email: " + contact.getEmail();
                res.setText(contactDetails);
                return;
            }
        }
        res.setText("Contact not found.");
    }

    @FXML
    public void initialize(){
        contactsListView.setCellFactory(this::renderCell);
        syncContacts();
        // Select the first contact and display its information
        contactsListView.getSelectionModel().selectFirst();
        Contact firstContact = contactsListView.getSelectionModel().getSelectedItem();
        if (firstContact != null){
            selectContact(firstContact);
        }
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> syncContacts());
    }

}