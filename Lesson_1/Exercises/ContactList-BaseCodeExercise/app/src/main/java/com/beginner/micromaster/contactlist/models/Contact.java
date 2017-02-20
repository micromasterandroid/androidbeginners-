package com.beginner.micromaster.contactlist.models;

import com.orm.SugarRecord;


import java.util.List;


public class Contact extends SugarRecord {

    private String name;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Contact() {
    }

    public Contact(String name, String lastName, String email, int phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "name:" + name + ", " +
                "lastName:" + lastName + ", " +
                "email:" + email + ", " +
                "phoneNumber:" + phoneNumber;

    }

    public static List<Contact> getAll() {
        return Contact.listAll(Contact.class);
    }
}
