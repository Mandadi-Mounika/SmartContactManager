package com.cg.contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.contact.dao.ContactDAO;
import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;
import com.cg.contact.service.ContactService;
import com.cg.contact.service.contactServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ContactServiceImplTests {

	@Mock
	private ContactDAO contactDAO;

	@InjectMocks
	private ContactService contactService = new contactServiceImpl();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
    void testGetContacts1() {
        // Arrange
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact());

        // Mock the behavior of contactDAO.findAll()
        when(contactDAO.findAll()).thenReturn(contacts);

        // Act
        List<Contact> result = contactService.getContacts1();

        // Assert
        assertEquals(contacts, result);
        verify(contactDAO, times(1)).findAll();
    }


	@Test
	public void testGetAllContacts() throws Exception {
		Contact contact1 = new Contact();
		contact1.setName(null);

		Contact contact2 = new Contact();
		contact2.setName(null);

		List<Contact> sampleOutput = new ArrayList<>();
		sampleOutput.add(contact1);
		sampleOutput.add(contact2);

		// then: verify the sampleOutput with actual output
	}

	@Test
	public void testAddContacts() {
		// Arrange
		Contact contact = new Contact();
		Mockito.when(contactDAO.save(contact)).thenReturn(contact);

		// Act
		Contact actualContact = contactService.addcontacts(contact);

		// Assert
		Assertions.assertEquals(contact, actualContact);
	}

	@Test
	public void testUpdateContacts() {
		// Arrange
		Contact contact = new Contact();
		Mockito.when(contactDAO.save(contact)).thenReturn(contact);

		// Act
		Contact actualContact = contactService.updatecontacts(contact);

		// Assert
		Assertions.assertEquals(contact, actualContact);
	}

	@Test
	public void testDeleteContactById_ContactPresent() throws ContactNotFoundException {
		// Arrange
		int contactId = 1;
		Contact contact = new Contact();
		Mockito.when(contactDAO.findById(contactId)).thenReturn(Optional.of(contact));

		// Act
		String message = contactService.deletecontactById(contactId);

		// Assert
		Assertions.assertEquals("Contact deleted successfully.", message);
		Mockito.verify(contactDAO, Mockito.times(1)).deleteById(contactId);
	}

	@Test
	public void testDeleteContactById_ContactNotFound() {
		// Arrange
		int contactId = 1;
		Mockito.when(contactDAO.findById(contactId)).thenReturn(Optional.empty());

		// Act & Assert
		Assertions.assertThrows(ContactNotFoundException.class, () -> contactService.deletecontactById(contactId));
	}
	   @Test
	    public void testGetContactById_ContactFound() throws ContactNotFoundException {
	        // Arrange
	        int id = 1;
	        Contact contact = new Contact();
	        when(contactDAO.findById(id)).thenReturn(Optional.of(contact));

	        // Act
	        Contact result = contactService.getContactByid(id);

	        // Assert
	        Assertions.assertEquals(contact, result);
	        verify(contactDAO, times(1)).findById(id);
	    }

	    @Test
	    public void testGetContactById_ContactNotFound() {
	        // Arrange
	        int id = 1;
	        when(contactDAO.findById(id)).thenReturn(Optional.empty());

	        // Act and Assert
	        Assertions.assertThrows(ContactNotFoundException.class, () -> {
	            contactService.getContactByid(id);
	        });
	        verify(contactDAO, times(1)).findById(id);
	    }
	
}

