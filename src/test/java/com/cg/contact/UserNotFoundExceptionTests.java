package com.cg.contact;

import org.junit.Test;

import com.cg.contact.exception.UserNotFoundException;

import static org.junit.Assert.*;

public class UserNotFoundExceptionTests {

    @Test
    public void testUserNotFoundException() {
        String errorMessage = "User not found";
        UserNotFoundException exception = new UserNotFoundException(errorMessage);
        
        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }
}
