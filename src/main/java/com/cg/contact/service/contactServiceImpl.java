package com.cg.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.contact.dao.ContactDAO;
import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;

@Service
public class contactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public List<Contact> getContacts1() {
		// TODO Auto-generated method stub
		return contactDAO.findAll();
	}

	public Contact addcontacts(Contact contact) {
		// TODO Auto-generated method stub
		contactDAO.save(contact);
		return contact;

	}

	public Contact updatecontacts(Contact contact) {
		// TODO Auto-generated method stub
		contactDAO.save(contact);
		return contact;
	}

	public String deletecontactById(int contactId) throws ContactNotFoundException {

		Optional<Contact> contact = contactDAO.findById(contactId);

		String message = null;

		if (contact.isPresent()) {
			contactDAO.deleteById(contactId);

			message = new String("Contact deleted successfully.");
		} else {
			throw new ContactNotFoundException("No such Contact");
		}

		return message;
	}

	@Override
	public Contact getContactByid(int id) throws ContactNotFoundException {
		return contactDAO.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("No contact present with id : " + id));

	}

}