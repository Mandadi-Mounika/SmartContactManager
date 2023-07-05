package com.cg.contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

import junit.framework.Assert;
@SpringBootTest
public class UserTests {

	private User user;
	private List<Contact> contacts;

	@Before
	public void setUp() {
		contacts = new ArrayList<>();
		contacts.add(new Contact());

		user = new User();
	}

	@Test
	public void testSetName() {
		user.setName("Bob");
		assertEquals("Bob", user.getName());
	}

	@Test
	public void testSetEmail() {
		user.setEmail("bob@example.com");
		assertEquals("bob@example.com", user.getEmail());
	}

	@Test
	public void testSetPassword() {
		user.setPassword("newpassword");
		assertEquals("newpassword", user.getPassword());
	}

	@Test
	public void testSetImageUrl() {
		user.setImageUrl("newimage.jpg");
		assertEquals("newimage.jpg", user.getImageUrl());
	}

	@Test
	public void testSetAbout() {
		user.setAbout("About Bob");
		assertEquals("About Bob", user.getAbout());
	}

	@Test
	public void testSetRole() {
		user.setRole("admin");
		assertEquals("admin", user.getRole());
	}

	@Test
	public void testSetEnabled() {
		user.setEnabled(false);
		assertFalse(user.isEnabled());
	}

	@Test
	public void testSetContacts() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact());
		user.setContacts(newContacts);
		assertEquals(newContacts, user.getContacts());
	}

	@Test
	public void testNotEquals() {
		User differentUser = new User(2, "Bob", "bob@example.com", "password", "image.jpg", "About Bob", "user", true,
				contacts);
		assertFalse(user.equals(differentUser));
	}
	@Test
	public void testGetId() {
	    User user = new User();
	    int expectedId = 1;
	    user.setId(expectedId);
	    assertEquals(expectedId, user.getId());
	}
	 @Test
	    public void testHashCodeSameObject() {
	        // Arrange
	        User user = new User();
	        user.setId(1);
	        user.setName("John Doe");

	        // Act
	        int hashCode1 = user.hashCode();
	        int hashCode2 = user.hashCode();

	        // Assert
	        Assertions.assertEquals(hashCode1, hashCode2);
	    }

	    @Test
	    public void testHashCodeEqualObjects() {
	        // Arrange
	        User user1 = new User();
	        user1.setId(1);
	        user1.setName("John Doe");

	        User user2 = new User();
	        user2.setId(1);
	        user2.setName("John Doe");

	        // Act
	        int hashCode1 = user1.hashCode();
	        int hashCode2 = user2.hashCode();

	        // Assert
	        Assertions.assertEquals(hashCode1, hashCode2);
	    }

	    @Test
	    public void testHashCodeDifferentObjects() {
	        // Arrange
	        User user1 = new User();
	        user1.setId(1);
	        user1.setName("John Doe");

	        User user2 = new User();
	        user2.setId(2);
	        user2.setName("Jane Smith");

	        // Act
	        int hashCode1 = user1.hashCode();
	        int hashCode2 = user2.hashCode();

	        // Assert
	        Assertions.assertNotEquals(hashCode1, hashCode2);
	    }
	    @Test
	    public void testEquals_SameInstance() {
	        User user = new User();
	        Assert.assertTrue(user.equals(user));
	    }

	    @Test
	    public void testEquals_Null() {
	        User user = new User();
	        Assert.assertFalse(user.equals(null));
	    }

	    @Test
	    public void testEquals_DifferentClass() {
	        User user = new User();
	        Object obj = new Object();
	        Assert.assertFalse(user.equals(obj));
	    }

	    @Test
	    public void testEquals_SameValues() {
	        User user1 = new User();
	        user1.setId(1);
	        user1.setName("John");
	        user1.setEmail("john@example.com");

	        User user2 = new User();
	        user2.setId(1);
	        user2.setName("John");
	        user2.setEmail("john@example.com");

	        Assert.assertTrue(user1.equals(user2));
	    }

	    @Test
	    public void testEquals_DifferentValues() {
	        User user1 = new User();
	        user1.setId(1);
	        user1.setName("John");
	        user1.setEmail("john@example.com");

	        User user2 = new User();
	        user2.setId(2);
	        user2.setName("Jane");
	        user2.setEmail("jane@example.com");

	        Assert.assertFalse(user1.equals(user2));
	    }
	


}

