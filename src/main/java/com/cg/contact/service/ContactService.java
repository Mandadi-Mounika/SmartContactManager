package com.cg.contact.service;

import java.util.List;

import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;

public interface ContactService {
	public List<Contact> getContacts1();

	public Contact addcontacts(Contact contact);

	public Contact updatecontacts(Contact contact);

	Contact getContactByid(int id) throws ContactNotFoundException;

	public String deletecontactById(int contactId) throws ContactNotFoundException;

}