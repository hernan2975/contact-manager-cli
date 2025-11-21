package com.tuempresa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactManager {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("Contact cannot be null");
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts); // defensive copy
    }

    public List<Contact> findByName(String name) {
        if (name == null) return new ArrayList<>();
        return contacts.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public int count() {
        return contacts.size();
    }
}
