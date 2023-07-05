package com.cg.contact.service;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cg.contact.dao.ContactRepository;
import com.cg.contact.dao.UserRepository;
import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

@Service
@Transactional
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ContactRepository contacRepository;
	private Object contactRepository;

	public User userRegister(User user) throws Exception {
		try {
			System.out.println("userService : " + user);
			return userRepository.save(user);
		} catch (Exception e) {
			// Handle the exception
			e.printStackTrace();
			// You can throw a custom exception or return null based on your requirements
			throw new Exception("Failed to register user. Please try again later.");
			// Alternatively, you can return null directly
			// return null;
		}
	}

	public User findUserByEmail(String email) throws Exception {
		try {
			User resultUser = userRepository.loadUserByUsername(email);
			return resultUser;
		} catch (Exception e) {
			// Handle the exception (log, display an error message, etc.)
			e.printStackTrace();
			return null;
		}
	}

	public User addContactInUser(User user) {
		try {
			if (user == null) {
				throw new IllegalArgumentException("User cannot be null.");
			}

			User result = userRepository.save(user);
			return result;
		} catch (Exception e) {
			// Handle the exception or log the error
			e.printStackTrace();
			return null; // Return null or throw a custom exception based on your requirement
		}
	}

	/** get all contacts list with respective users UserID */
	public Page<Contact> getContactsList(int userId, Pageable pageable) {
		Page<Contact> listContactsByUser = this.contacRepository.getContactsByUser(userId, pageable);
		return listContactsByUser;
	}

	public Contact getContactDetail(int cId) {
		@SuppressWarnings("unchecked")
		Optional<Contact> optionalContact = ((CrudRepository<Contact, Integer>) this.contactRepository).findById(cId);
		if (optionalContact.isPresent()) {
			return optionalContact.get();
		} else {
			return null;
		}
	}

	public Contact getContactById(int cId) {
		Optional<Contact> optionalContact = this.contacRepository.findById(cId);
		try {
			return optionalContact.orElseThrow();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/** delete contact by using ID */

	public void deleteContact(User user, Contact contact) {

		try {

			/** It is not deleted directly because its is mapped with user */
			user.getContacts().remove(contact);

			// contact.setUser(null);
			// this.contacRepository.delete(contact);

			// Now we must delete photo from folder
			File saveFile = new ClassPathResource("/static/image").getFile();

			File deleteFile = new File(saveFile, contact.getImage());
			deleteFile.delete();
			System.out.println(contact.getcId() + "ID Contact deleted successfully ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Contact updateContactInUser(Contact contact) {
		try {
			Contact saveContact = ((CrudRepository<Contact, Integer>) this.contactRepository).save(contact);
			return saveContact;
		} catch (Exception e) {
			// Handle the exception, log an error, or perform any necessary actions
			e.printStackTrace();
			return null; // Or throw a custom exception if desired
		}
	}

}