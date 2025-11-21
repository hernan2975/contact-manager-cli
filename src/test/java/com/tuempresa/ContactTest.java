package com.tuempresa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("Ana", "ana@example.com", "123456");
        assertEquals("Ana", c.getName());
        assertEquals("ana@example.com", c.getEmail());
        assertEquals("123456", c.getPhone());
    }

    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "a@b.com", "123");
        });
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "invalid-email", "123");
        });
    }

    @Test
    void testEqualsAndHash() {
        Contact c1 = new Contact("Carlos", "carlos@test.com", "");
        Contact c2 = new Contact("Carlos", "carlos@test.com", "000");
        Contact c3 = new Contact("Diana", "diana@test.com", "");

        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
