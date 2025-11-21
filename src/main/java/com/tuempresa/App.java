package com.tuempresa;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Contact Manager CLI ===");
        System.out.println("Comandos: ADD, LIST, SEARCH <nombre>, QUIT");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String command = parts[0].toUpperCase();

            try {
                switch (command) {
                    case "ADD":
                        handleAdd(manager, scanner);
                        break;
                    case "LIST":
                        handleList(manager);
                        break;
                    case "SEARCH":
                        String query = parts.length > 1 ? parts[1] : "";
                        handleSearch(manager, query);
                        break;
                    case "QUIT":
                        System.out.println("Adiós.");
                        return;
                    default:
                        System.out.println("Comando desconocido. Usa: ADD, LIST, SEARCH, QUIT");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleAdd(ContactManager manager, Scanner scanner) {
        System.out.print("Nombre: ");
        String name = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Teléfono (opcional): ");
        String phone = scanner.nextLine().trim();

        try {
            Contact contact = new Contact(name, email, phone);
            manager.addContact(contact);
            System.out.println("✅ Contacto agregado.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void handleList(ContactManager manager) {
        var contacts = manager.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos.");
        } else {
            System.out.println("Listado (" + contacts.size() + "):");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, contacts.get(i));
            }
        }
    }

    private static void handleSearch(ContactManager manager, String query) {
        if (query.isEmpty()) {
            System.out.println("Uso: SEARCH <nombre>");
            return;
        }
        var results = manager.findByName(query);
        if (results.isEmpty()) {
            System.out.println("No se encontraron contactos con \"" + query + "\".");
        } else {
            System.out.println("Resultados (" + results.size() + "):");
            for (var c : results) {
                System.out.println("- " + c);
            }
        }
    }
}
