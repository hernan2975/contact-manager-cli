package com.tuempresa;

import java.util.Objects;

public class Contact {
    private final String name;
    private final String email;
    private final String phone;

    public Contact(String name, String email, String phone) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.name = name.trim();
        this.email = email.trim();
        this.phone = phone != null ? phone.trim() : "";
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
               Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return String.format("Contact{name='%s', email='%s', phone='%s'}", name, email, phone);
    }
}
