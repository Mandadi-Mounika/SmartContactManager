package com.cg.contact;

import org.junit.Test;

import com.cg.contact.exception.ContactNotFoundException;

import static org.junit.Assert.*;

public class ContactNotFoundExceptionTests {

    @Test
    public void testContactNotFoundException() {
        String errorMessage = "Contact not found";
        ContactNotFoundException exception = new ContactNotFoundException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}
