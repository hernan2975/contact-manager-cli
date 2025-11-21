class ContactManagerTest {
    @Test
    void testAddAndGetContacts() {
        ContactManager manager = new ContactManager();
        Contact c = new Contact("Eva", "eva@demo.com", "789");
        manager.addContact(c);
        assertEquals(1, manager.count());
        assertEquals(1, manager.getAllContacts().size());
        assertTrue(manager.getAllContacts().contains(c));
    }

    @Test
    void testFindByName() {
        ContactManager manager = new ContactManager();
        manager.addContact(new Contact("Luis", "luis@test.com", ""));
        manager.addContact(new Contact("Lucía", "lucia@test.com", ""));

        var results = manager.findByName("Lu");
        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(c -> c.getName().equals("Luis")));
    }
}
