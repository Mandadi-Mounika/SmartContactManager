package com.cg.contact;

import org.junit.Test;

import com.cg.contact.exception.ImageNotFoundException;

import static org.junit.Assert.*;

public class ImageNotFoundExceptionTests {

    @Test
    public void testImageNotFoundExceptionWithMessage() {
        String errorMessage = "Image not found!";
        ImageNotFoundException exception = new ImageNotFoundException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testImageNotFoundExceptionWithoutMessage() {
        ImageNotFoundException exception = new ImageNotFoundException(null);

        assertNull(exception.getMessage());
    }
}
