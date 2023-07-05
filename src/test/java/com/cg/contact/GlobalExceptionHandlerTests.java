package com.cg.contact;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.contact.exception.ImageNotFoundException;
import com.cg.contact.handler.GlobalExceptionHandler;

@SpringBootTest
public class GlobalExceptionHandlerTests {

    @Mock
    private ImageNotFoundException imageNotFoundException;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    public void handleImageNotFoundException_ReturnsErrorMessage() {
        // Arrange
        String errorMessage = "Image not found";
        Mockito.when(imageNotFoundException.getMessage()).thenReturn(errorMessage);

        // Act
        String result = globalExceptionHandler.handleImageNotFoundException(imageNotFoundException);

        // Assert
        assertEquals(errorMessage, result);
    }
}
