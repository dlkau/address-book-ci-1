package com.example.addressbook.model;

import java.util.regex.Pattern;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     * This constructor is used to instantiate a new Contact object.
     * @param firstname the first name of the contact.
     * @param lastName The last name of the contact.
     * @param email The email of the contact.
     * @param phone The phone number of the contact.
     */
    public Contact(String firstname, String lastName, String email, String phone){
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // Below there are a series of getter and setters for the attributes listed above
    public int getId(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstname(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        // Check the email address before adding the contact
        String pattern = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        boolean isValidEmail = Pattern.compile(pattern).matcher(email).matches();
        // Return if it is not a valid email
        if(isValidEmail){
            this.email = email;
        }

    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getFullName(){
        return firstName + " " + lastName + "(" + email + ")";
    }
}