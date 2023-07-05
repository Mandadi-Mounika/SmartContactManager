package com.cg.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.contact.controller.ContactController;
import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;
import com.cg.contact.service.contactServiceImpl;

@SpringBootTest
public class ContactControllerTests {

	@Mock
	private contactServiceImpl contactService;

	@InjectMocks
	private ContactController contactController;

	private MockMvc MockMvc;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetContactById() throws ContactNotFoundException {
		// Arrange
		int contactId = 1;
		Contact contact = new Contact();
		contact.setcId(contactId);
		when(contactService.getContactByid(contactId)).thenReturn(contact);

		// Act
		Contact result = contactController.getContactById(contactId);

		// Assert
		assertEquals(contact, result);
		verify(contactService, times(1)).getContactByid(contactId);
	}

	@Test
	public void testGetContacts() {
		// Arrange
		List<Contact> contacts = Arrays.asList(new Contact(), new Contact());
		when(contactService.getContacts1()).thenReturn(contacts);

		// Act
		List<Contact> result = contactController.getContacts();

		// Assert
		assertEquals(contacts, result);
		verify(contactService, times(1)).getContacts1();
	}

	@Test
	public void testAddContacts() {
		// Arrange
		Contact contact = new Contact();
		when(contactService.addcontacts(contact)).thenReturn(contact);

		// Act
		Contact result = contactController.addContacts(contact);

		// Assert
		assertEquals(contact, result);
		verify(contactService, times(1)).addcontacts(contact);
	}

	@Test
	public void testUpdateContacts() {
		// Arrange
		Contact contact = new Contact();
		when(contactService.updatecontacts(contact)).thenReturn(contact);

		// Act
		Contact result = contactController.updateContacts(contact);

		// Assert
		assertEquals(contact, result);
		verify(contactService, times(1)).updatecontacts(contact);
	}

	@Test
	public void testDeleteContactById() throws ContactNotFoundException {
		// Arrange
		int contactId = 1;

		// Act
		String result = contactController.deleteContactById(contactId);

		// Assert
		assertEquals("Contact Deleted Successfully.....", result);
		verify(contactService, times(1)).deletecontactById(contactId);
	}

	@BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ContactController contactController = new ContactController();
        MockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

   

	

}
