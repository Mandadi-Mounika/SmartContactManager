package com.cg.contact;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.cg.contact.exception.CustomErrorDetails;

import java.util.Date;

public class CustomErrorDetailsTests {

    @Test
    public void testGetMessage() {
        String expectedMessage = "Test Message";
        Date date = new Date();
        String details = "Test Details";
        CustomErrorDetails errorDetails = new CustomErrorDetails(expectedMessage, date, details);
        
        String actualMessage = errorDetails.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetDate() {
        String message = "Test Message";
        Date expectedDate = new Date();
        String details = "Test Details";
        CustomErrorDetails errorDetails = new CustomErrorDetails(message, expectedDate, details);
        
        Date actualDate = errorDetails.getDate();

        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testGetDetails() {
        String message = "Test Message";
        Date date = new Date();
        String expectedDetails = "Test Details";
        CustomErrorDetails errorDetails = new CustomErrorDetails(message, date, expectedDetails);
        
        String actualDetails = errorDetails.getDetails();

        assertEquals(expectedDetails, actualDetails);
    }
}
