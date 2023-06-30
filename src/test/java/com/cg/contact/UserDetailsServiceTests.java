package com.cg.contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.contact.configure.UserDetailsService;

import com.cg.contact.dao.UserRepository;
import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

import junit.framework.Assert;

class UserDetailsServiceTests<ContactList> {

	private static final UserDetailsService UserDetailsService = null;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserDetailsService userService;

	@SuppressWarnings("unused")
	@Test

	public void testUserRegister() throws Exception {
		// Create a UserService instance
		UserDetailsService userService = (UserDetailsService);

		// Create a user object
		User user = new User();

		// Call the userRegister method
		User registeredUser = userService.userRegister(user);

		// Assert that the registeredUser is not null
		Assertions.assertNotNull(registeredUser);

		// Assert that the registeredUser has the same properties as the input user
		Assertions.assertEquals(user.getName(), registeredUser.getName());
		Assertions.assertEquals(user.getEmail(), registeredUser.getEmail());

		// Assert that the registeredUser has been assigned an ID
		Assertions.assertNotNull(registeredUser.getId());

		// Assert any other necessary conditions for user registration

		// For example, if the registered user should have an active status
		Assertions.assertTrue(registeredUser.isActive1(), "User should be active.");

		// If the user registration throws an exception, the test will fail
	}
	@Test
	public void testAddContactInUser() throws Exception {
		User user = new User(); // Create a user instance

		// Test case 1: Adding a contact that doesn't exist in the user's contact list
		User contact1 = new User(); // Create a contact instance
		User result1 = user.addContactInUser1(contact1); // Add the contact to the user's contact list
		Assertions.assertTrue(result1.getContacts().contains(contact1)); // Assert that the contact is added

		// Test case 2: Adding a contact that already exists in the user's contact list
		User contact2 = new User(); // Create another contact instance
		user.addContactInUser1(contact2); // Add the contact to the user's contact list
		User result2 = user.addContactInUser1(contact2); // Attempt to add the contact again
		Assertions.assertEquals(user.getContacts().size(), result2.getContacts().size()); // Assert that the contact is
																							// not duplicated

		// Test case 3: Adding null contact
		User result3 = user.addContactInUser1(null); // Add null contact to the user's contact list
		Assertions.assertFalse(result3.getContacts().contains(null)); // Assert that null contact is not added

		// Additional test cases can be added based on specific requirements or edge
		// cases
	}



	@Test
	public void testGetContactById_ExistingId_ReturnsContact() {
		// Arrange
		int contactId = 1;

		UserDetailsService contactService = null;
		// Act
		Contact result = contactService.getContactById(contactId);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(contactId, result.getcId());
	}

	@Test
	public void testGetContactById_NonExistingId_ReturnsNull() {
		// Arrange
		int contactId = 2; // Assuming contact with ID 2 doesn't exist

		UserDetailsService contactService = null;
		Contact result = contactService.getContactById(contactId);

		// Assert
		Assert.assertNull(result);
	}
	
}
