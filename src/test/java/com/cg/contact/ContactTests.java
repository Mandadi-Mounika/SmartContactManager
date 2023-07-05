package com.cg.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContactTests {
    private Contact contact;
    private User mockUser;

    @BeforeEach
    public void setUp() {
        mockUser = mock(User.class);
        contact = new Contact(1, "John", "Doe", "Work", "john@example.com", "image.jpg", "1234567890",
                "Description", mockUser);
    }

    @Test
    public void testGetters() {
        assertEquals(1, contact.getcId());
        assertEquals("John", contact.getName());
        assertEquals("Doe", contact.getSecondName());
        assertEquals("Work", contact.getWork());
        assertEquals("john@example.com", contact.getEmail());
        assertEquals("image.jpg", contact.getImage());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Description", contact.getDescription());
        assertEquals(mockUser, contact.getUser());
    }

    @Test
    public void testSetters() {
        contact.setcId(2);
        contact.setName("Jane");
        contact.setSecondName("Smith");
        contact.setWork("New Work");
        contact.setEmail("jane@example.com");
        contact.setImage("newimage.jpg");
        contact.setPhone("9876543210");
        contact.setDescription("New Description");
        User newUser = mock(User.class);
        contact.setUser(newUser);

        assertEquals(2, contact.getcId());
        assertEquals("Jane", contact.getName());
        assertEquals("Smith", contact.getSecondName());
        assertEquals("New Work", contact.getWork());
        assertEquals("jane@example.com", contact.getEmail());
        assertEquals("newimage.jpg", contact.getImage());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("New Description", contact.getDescription());
        assertEquals(newUser, contact.getUser());
    }

    @Test
    public void testToString() {
        String expected = "Contact [cId=1, name=John, secondName=Doe, work=Work, email=john@example.com, image=image.jpg, description=Description, phone=1234567890, user=" + mockUser + "]";
        assertEquals(expected, contact.toString());
    }
}
