package com.cg.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;


@Service
public interface ContactService {
	public Contact getContactById(int contact_id);
	public List<Contact> getContacts();
	public Contact addContacts(Contact contactDAO);
	public Contact updateContacts(Contact contact);
	public void deleteContactById(int contact_Id);
	Contact addcontacts(Contact contact);
	List<Contact> getcontacts();
	Contact updatecontacts(Contact contact);
	String deletecontactById(int contactId) throws ContactNotFoundException;
	
 

}