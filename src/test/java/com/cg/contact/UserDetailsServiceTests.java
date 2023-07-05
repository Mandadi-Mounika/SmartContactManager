package com.cg.contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.cg.contact.dao.ContactRepository;
import com.cg.contact.dao.UserRepository;
import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;
import com.cg.contact.service.UserDetails;
import com.cg.contact.service.UserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private UserDetailsService userDetailsService;

	private User user;
	private Contact contact;

	@Before
	public void setup() {
		user = new User();
		user.setId(0);
		user.setEmail("test@example.com");

		contact = new Contact();
		contact.setcId(1);
		contact.setName("John Doe");
		contact.setUser(user);
	}

	@Test
	public void testUserRegister_Success() throws Exception {
		when(userRepository.save(any(User.class))).thenReturn(user);

		User result = userDetailsService.userRegister(user);

		assertNotNull(result);
		assertEquals(user, result);
	}

	@Test(expected = Exception.class)
    public void testUserRegister_Exception() throws Exception {
        // Mock the userRepository.save() method to throw an exception
        when(userRepository.save(any(User.class))).thenThrow(new Exception());
        
        // Call the method under test
        userDetailsService.userRegister(user);
        
        // The exception is expected to be thrown during the method execution
    }

	@Test
	public void testFindUserByEmail_Success() throws Exception {
		when(userRepository.loadUserByUsername(user.getEmail())).thenReturn(user);

		User result = userDetailsService.findUserByEmail(user.getEmail());

		assertNotNull(result);
		assertEquals(user, result);
	}

	@Test
	public void testFindUserByEmail_NotFound() throws Exception {
		when(userRepository.loadUserByUsername(user.getEmail())).thenReturn(null);

		User result = userDetailsService.findUserByEmail(user.getEmail());

		assertNull(result);
	}

	@Test
	public void testAddContactInUser_Success() {
		when(userRepository.save(any(User.class))).thenReturn(user);

		User result = userDetailsService.addContactInUser(user);

		assertNotNull(result);
		assertEquals(user, result);
	}

	@Test
	public void testGetContactById_Success() {
		Optional<Contact> optionalContact = Optional.of(contact);
		when(contactRepository.findById(contact.getcId()));
	}

    @Test
    public void testGetContactsList() {
        // Prepare test data
        User user = new User();
        user.setId(1);
        Contact contact1 = new Contact();
        contact1.setcId(1);
        Contact contact2 = new Contact();
        contact2.setcId(2);
        Page<Contact> expectedPage = new PageImpl<>(List.of(contact1, contact2));

        // Mock the repository method
        when(contactRepository.getContactsByUser(1, org.springframework.data.domain.Pageable.unpaged())).thenReturn(expectedPage);

        // Invoke the service method
        Page<Contact> actualPage = userDetailsService.getContactsList(1, org.springframework.data.domain.Pageable.unpaged());

        // Assert the result
        assertEquals(expectedPage, actualPage);
    }
    

  
  


}

