package com.cg.contact;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.cg.contact.controller.UserController;
import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;
import com.cg.contact.service.UserDetailsService;

public class UserControllerTests {

	@Mock
	private UserDetailsService userDetailsService;

	@InjectMocks
	private UserController userController;

	private Model model;

	private Principal principal;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddUserContact() {
		Model model = mock(Model.class);

		String result = userController.addUserContact(model);

		assertEquals("user/add_contact_form", result);
	}

	@Test
	public void testRegisterUser() throws Exception {
		User user = new User();
		user.setEmail("test@example.com");

		when(userDetailsService.userRegister(user)).thenReturn(user);

		ResponseEntity<User> response = userController.registerUser(user);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}

	@Test
	public void testGetUserByEmail() throws Exception {
		String email = "test@example.com";
		User user = new User();
		user.setEmail(email);

		when(userDetailsService.findUserByEmail(email)).thenReturn(user);

		ResponseEntity<User> response = userController.getUserByEmail(email);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}

	@Test
	public void testAddContactToUser() {
		int userId = 1;
		User user = new User();
		user.setId(userId);

		when(userDetailsService.addContactInUser(user)).thenReturn(user);

		ResponseEntity<User> response = userController.addContactToUser(userId, user);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}

	@Test
	public void testGetContactById() {
		int contactId = 1;
		Contact contact = new Contact();
		contact.setcId(contactId);

		when(userDetailsService.getContactById(contactId)).thenReturn(contact);

		ResponseEntity<Contact> response = userController.getContactById(contactId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(contact, response.getBody());
	}

	@Test
	public void testUpdateContact() {
		Contact contact = new Contact();
		contact.setcId(1);

		when(userDetailsService.updateContactInUser(contact)).thenReturn(contact);

		ResponseEntity<Contact> response = userController.updateContact(contact);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(contact, response.getBody());
	}

}
